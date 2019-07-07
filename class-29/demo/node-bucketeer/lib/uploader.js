'use strict';

// Requires: AWS_ACCESS_KEY and AWS_SECRET_KEY environment variables
const uuid = require('uuid/v4');
const fs = require('fs-extra');
const AWS = require('aws-sdk');
const s3 = new AWS.S3();

module.exports = (bucket, source, mimetype, name) => {

  let config = {
    Bucket: bucket,
    Key: `${name}`,
    ACL: 'public-read',
    ContentType: mimetype,
    Body: fs.createReadStream(source),
  };

  return s3.upload(config)
    .promise()
    .then(res => {
      return res.Location;
    })
    .catch(err => Promise.reject(err));
};
