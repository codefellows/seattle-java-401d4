'use strict';

require('dotenv').config();
const uuid = require('uuid/v4');
const express = require('express');
const multer = require('multer');
const AWS = require('aws-sdk');
const uploader = require('./lib/uploader.js');

const app = express();
const multipart = multer({dest:`${__dirname}/uploads`});

AWS.config.update({
  region: 'us-west-2',
});

const dynamodb = new AWS.DynamoDB();

app.use(express.urlencoded({extended:true}));
app.use(express.json());

app.get('/people', getAllRecords);

app.post('/people', multipart.any(), createRecord);

function getAllRecords( req, res, next ) {

  let params = {
    TableName: 'people',
  };

  dynamodb.scan(params, function(err, data) {
    if (err) {
      next(err);
    } else {
      res.send(data);
    }
  });
}

function createRecord( req, res, next ) {

  if(! req.files.length) {
    next('Invalid File Upload');
  }

  let file = req.files[0];
  let name = req.body.name;
  let old = !! req.body.old;

  uploader(process.env.AWS_BUCKET, file.path, file.mimetype, file.originalname)
    .then(url => {
      let record = {
        TableName: 'people',
        Item: {
          id : {S: uuid()},
          name : {S: name},
          pic : {S: url},
          old: {BOOL: old},
        },
      };

      dynamodb.putItem(record, function(err, data) {
        (err & next(err)) || res.send(data);
      });

    })
    .catch(next);
}

app.listen(3000, () => console.log('up on 3000'));


