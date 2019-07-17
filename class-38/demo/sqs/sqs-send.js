'use strict';

const uuid = require('uuid/v4');
const Producer = require('sqs-producer');

// create simple producer
const producer = Producer.create({
  queueUrl: 'https://sqs.us-west-2.amazonaws.com/092793752763/MichelleCoolQueue',
  region: 'us-west-2'
});

//const producer = Producer.create({
//  queueUrl: 'https://sqs.eu-west-1.amazonaws.com/account-id/queue-name',
//  region: 'eu-west-1'
//  accessKeyId: 'yourAccessKey',
//  secretAccessKey: 'yourSecret'
//});



setInterval( () => {

  const random = Math.floor(Math.random() * 100);
  const message = {
    id:uuid(),
    body:`This is a new message with a random number ${random}`,
  };

  producer.send(message, function(err,msg) {
    if (err) { console.log(err); }
  });

}, Math.floor(Math.random() * 500));


