# Deploying New Apps

## What first steps might we take?
- Read READMEs, see what documentation they have
    - Structure of site?
    - Deployment guide?
        - if the guide is good enough, I don't have to do much work
        - not super likely, but we can hope
        - build step? does it create static files vs files in some language that need to be run
    - Readable and simple, but thorough
    - sample deployment? "this is what it looks like if you deploy it right"?
- Run app locally
    - installing dependencies
        - consider versions available on AWS
    - Write down the steps I take to get it running locally
        - if I can replicate those steps in deployment, it should run there too
- Look at the code
- Look at structure of site/code
    - Does it require databases?
    - Calling external APIs?
    - Generating an API of its own?
    - BE/FE?
    - Testing?
- Look for how environment/language/framework match up with AWS services
    - List of relevant AWS services
    - Drawing of how those services interact
- Documentation

## Once we have an idea of what to deploy/have it running locally, what should we try next?
- Try to deploy with Elastic Beanstalk to see if it's possible
- Try putting data into it/confirm the data is in the local database
- Put the DB in the cloud, make sure I can connect to it locally
- Connect to S3 locally, make sure images get uploaded there
- Documentation

## We have it deployed to ElasticBeanstalk, it's working, hooray! what next?
- Think about pipelines! Get some sort of CI/CD going
- Documentation

## Advanced Stuff
- Breaking the server into lambdas!
- Switching the DB platform!
- Reading code, figuring out how it works
