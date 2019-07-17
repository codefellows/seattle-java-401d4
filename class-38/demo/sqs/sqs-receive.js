'use strict';

const { Consumer } = require('sqs-consumer');

const app = Consumer.create({
  queueUrl: "https://sqs.us-west-2.amazonaws.com/092793752763/MichelleCoolQueue",
  handleMessage: handler
});

function handler(message) {
  console.log(message.Body);
}

app.on('error', (err) => {
  console.error(err.message);
});

app.on('processing_error', (err) => {
  console.error(err.message);
});

app.start();

