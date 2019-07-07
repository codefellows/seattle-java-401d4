'use strict';

const uuid = require('uuid/v4');
const express = require('express');
const fs = require('fs-extra');
const multer = require('multer');
const AWS = require('aws-sdk');

const app = express();
const uploader = multer({dest:`${__dirname}/uploads`});

AWS.config.update({
  region: 'us-west-2',
});

const dynamodb = new AWS.DynamoDB();
const s3 = new AWS.S3();

app.use(express.urlencoded({extended:true}));
app.use(express.json());

app.get('/people', getAllRecords);

app.post('/people', uploader.any(), createRecord);

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

  upload(file)
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

function upload(file) {

  let config = {
    Bucket: 'cokos-people',
    Key: `${file.filename}.${file.originalname}`,
    ACL: 'public-read',
    ContentType: file.mimetype,
    Body: fs.createReadStream(file.path),
  };

  return s3.upload(config)
    .promise()
    .then(res => {
      return fs.remove(file.path)
        .then( () => res.Location);
    })
    .catch(err => {
      return fs.remove(file.path)
        .then( () => Promise.reject(err) );
    });

}

app.listen(3000, () => console.log('up on 3000'));


