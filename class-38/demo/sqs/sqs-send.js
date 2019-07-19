'use strict';

const uuid = require('uuid/v4');
const Producer = require('sqs-producer');

// create simple producer
const producer = Producer.create({
  queueUrl: 'https://sqs.us-west-2.amazonaws.com/092793752763/AGoodName',
  region: 'us-west-2'
});

//const producer = Producer.create({
//  queueUrl: 'https://sqs.eu-west-1.amazonaws.com/account-id/queue-name',
//  region: 'eu-west-1'
//  accessKeyId: 'yourAccessKey',
//  secretAccessKey: 'yourSecret'
//});


let i = 0;
// every so often
setInterval( () => {

  // pick a random number 0-99
  const random = i++;
  const message = {
    id:uuid(),
    body:`This is a new message with a random number ${random}`,
  };
  // send the message object to the SQS queue (with some error handling!)
  producer.send(message, function(err,msg) {
    if (err) { console.log(err); }
  });

}, 250);


