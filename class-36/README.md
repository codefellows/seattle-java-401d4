# Lecture 36: Continuous Deployment and Continuous Integration

## Agenda

- Announcements
    - Whiteboard finals have begun! Everyone's has been scheduled.
    - Readings have appeared, due starting tomorrow!
    - Feedback review
- Code review
    - graphz
- Lecture
    - What is CI/CD
    - Why
    - How
- Lab intro

## Feedback Review

### The Good/Most Helpful

- having me back <3
- switching from TaskMaster to standalone labs
    - more standalone is coming this week, too... for better or for worse!
- mock interviews/whiteboard prep
- Demos/code examples

### The Least Helpful

- Tech talk assignment
    - It's new, and that's an adjustment
- Requests for more cheat sheets for these services
    - This week, we automate some of that deployment work

## AWS Code Pipeline

AWS CodePipeline is a continuous integration and continuous delivery service for fast and reliable application and infrastructure updates. CodePipeline builds, tests, and deploys your code every time there is a code change, based on the release process models you define.

You will still setup each stage in the process manually, to get the core functionality correct and tested.

Whereas you may run them now tactically and independently,what Code Pipeline does for you is to tie each of the stages together and fire them synchronously. If a stage fails, the deployment stops at that phase.

This relieves you from having to manage the state of your application through all of AWS.

### Stages and Components

1. Source
2. Build
3. Deploy

#### Source
Identify the source of your code. When changes are detected in your source of origin, the pipeline will "fire up" and start the process.

- github - your source code can be identified by both repository and branch
- Amazon "Code Commit" - a git based SCM
- S3 - Identify a bucket as your source

This phase ends with an artifact that is passed along to the next phase.

#### Build
Setup AWS Code Build with a custom build for your application. Often, this is where you'll do your compilation, automated testing, and other prep for deployment.

This stage can simply be a boolean pass/fail, or it can result in an artifact to send to the next phase.

#### Deploy
Once you have your source and have done a build, and any testing, the last phase of the process is to roll out your application to its target system, such as:

- Elastic Beanstalk
- EC2
- S3
- Cloudfront
- etc.

You'll identify the rules in this phase that govern which system your code will deploy to.

