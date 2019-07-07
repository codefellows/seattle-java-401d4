# Class 04: Programmatic S3 Uploads

## Agenda

- Announcements
- Code review
- Lecture
- Lab intro

## Notes

### Setup Your S3 Bucket for Uploading
* Create a new S3 Bucket
* Create an "open" policy

```javascript
{
    "Version": "2012-10-17",
    "Id": "Policy1562466412724",
    "Statement": [
        {
            "Sid": "Stmt1562466394793",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:*",
            "Resource": "YOUR ARN HERE
        }
    ]
}
```

### Front End Code
* You'll need to use an html form, POSTing to your server, using the encoding type "multipart"
  * `<form action="http://localhost:3000/route" method="post" enctype="multipart/form-data">`
  * Every input field must have a `name`
  * You must have an `<input type='file' />` to store the file for upload
* Multi Part forms are broken into sections or chunks by the browser, simulating TCP-like packets so the back-end server can handle large amounts of data
* These chunks are split by "boundaries", which your application needs to digest, not unlike
  * Query Strings
  * Post Data
  * JSON Body
  
```javascript
------WebKitFormBoundaryCN5NrYyqER1HdCXn
Content-Disposition: form-data; name="person"

Johnny Socko
------WebKitFormBoundaryCN5NrYyqER1HdCXn
Content-Disposition: form-data; name="old"

false
------WebKitFormBoundaryCN5NrYyqER1HdCXn
Content-Disposition: form-data; name="file"; filename=""
Content-Type: application/octet-stream

BinaryFileNonsenseInHere...
```

### Server Code
On the server side, you'll need to connect to your S3 Bucket using your AWS Developer Credentials. 

**References**

* [Programmatic S3 uploads with Java](https://docs.aws.amazon.com/AmazonS3/latest/dev/UploadObjSingleOpJava.html)
* [Uploading to AWS with Spring Boot](https://medium.com/oril/uploading-files-to-aws-s3-bucket-using-spring-boot-483fcb6f8646)
