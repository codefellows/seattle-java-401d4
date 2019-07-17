'use strict';

const express = require('express');
const sns = require('express-aws-sns');
const app = express();

app.use(sns({topic:'arn:aws:sns:us-west-2:335083857671:database'}));

app.post('/receive', (req,res) => {
  res.status(200).send(req.snsMessage);
});

app.listen(3000);
