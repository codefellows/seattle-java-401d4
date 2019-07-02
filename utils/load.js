'use strict';

require('dotenv').config();

const faker = require('faker');
const uuid = require('uuid/v4');
const AWS = require("aws-sdk");

AWS.config.update({
  region: "us-west-2",
});

let dynamodb = new AWS.DynamoDB();
let ddbClient = new AWS.DynamoDB.DocumentClient();


const getAll = () => {

  let params = {
    TableName: 'todo'
  };

  dynamodb.scan(params, function(err, data) {
    if (err) {
      console.log("Error", err);
    } else {
      console.log(data);
    }
  });

};


const addRecord = (record) => {

  let params = {
    TableName: 'todo',
    Item: {
      "id": uuid(),
      "assigned":faker.name.firstName(),
      "complete":faker.random.boolean().toString(),
      "tasks":["a","b","c",{d:[1,2,3]}]
    }
  };

  // Call DynamoDB to add the item to the table
  ddbClient.put(params, function(err, data) {
    if (err) {
      console.log("Error", err);
    } else {
      // console.log('added ...', data);
    }
  });

  let paramsV2 = {
    TableName: 'todo',
    Item: {
      id : {S: uuid()},
      text : {S: faker.company.bs()},
      complete: {S:faker.random.boolean().toString()}
    }
  };

  dynamodb.putItem(paramsV2, function(err, data) {
    if (err) {
      console.log("Error", err);
    } else {
      // console.log('ok');
    }
  });



};


const recordsToAdd = parseInt(process.argv.slice(2)[0]) || 1;
console.log(recordsToAdd);

for(let i=recordsToAdd; i>0; i--) {
  console.log(`${i} to go ...`);
  addRecord();
}

console.log('done');
