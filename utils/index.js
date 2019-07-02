'use strict';

require('dotenv').config();

const faker = require('faker');
const uuid = require('uuid/v4');
const express = require('express');
const router = express.Router();
const AWS = require("aws-sdk");

const app = express();

AWS.config.update({
  region: "us-west-2",
});

var dynamodb = new AWS.DynamoDB();

var params = {
      Limit: 10
};

app.get('/tables', function (req, res) {
      dynamodb.listTables(params, function (err, data) {
            if (err) console.log(err, err.stack); // an error occurred
            else {
                  res.send(data);
            }
      });
});

app.get('/todo', function(req,res) {

  var params = {
    TableName: 'todo'
  };

  dynamodb.scan(params, function(err, data) {
    if (err) {
      console.log("Error", err);
      res.send('error');
    } else {
      res.send(data);
    }
  });

});


app.post('/todo', function(req,res) {

  let params = {
    TableName: 'todo',
    Item: {
      id : {S: uuid()},
      text : {S: faker.company.bs()},
      complete: {S:faker.random.boolean().toString()}
    }
  };

  // Call DynamoDB to add the item to the table
  dynamodb.putItem(params, function(err, data) {
    if (err) {
      console.log("Error", err);
      res.send('error');
    } else {
      res.send(data);
    }
  });

});

app.listen(3000, () => console.log('up on 3000'));


