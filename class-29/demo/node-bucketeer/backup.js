'use strict';

require('dotenv').config();

const fs = require('fs-extra');
const mimetype = require('mimetype');
const uploader = require('./lib/uploader.js');

const folder = '/Users/john/Downloads/images';

fs.readdir(folder, (err,files) => {
  files.forEach(fileName => {
    const file = `${folder}/${fileName}`;
    fs.stat(file, (err,fileInfo) => {
      if(fileInfo.isFile()) {
        // If object at s3 does not exist or has a different modified date ...
        uploader(process.env.AWS_BUCKET, file, mimetype.lookup(file), fileName)
          .then(url => {
            console.log(url);
          })
          .catch(err => console.error(`Error uploading ${file}`));
      }
    });
  });
});

