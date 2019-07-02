# Deployment with EC2 and RDS

## Background
Deploying a web app to EC2 traditionally requires writing a startup script in Bash to do things like copy your app's .jar file from S3, install dependencies, set environment variables, set up Apache with port forwarding from 80 to your app, and start up Apache. This is a lot of manual effort, and we can use Elastic Beanstalk for deployment to avoid this manual work, but we do NOT want to use Elastic Beanstalk for database; it limits our possibilities and can lead to bad situations. This doc walks through the process of setting up RDS manually, deploying to EC2 with Elastic Beanstalk, and connecting the two.

## Steps

1. Using the AWS Console (online), create a new RDS instance. Give your database a name (and write it down), and specify a username and password (that you also write down or remember). Give the instance "public accessibility" so that you'll be able to access it from the app you deploy. Note the full connection string for that database, which will appear after you've created it.
  Details:
  ```
  Click Create a Database. 
  Select PostgresQL. 
  Click the checkbox to only enable options eligible for RDS Free Usage Tier. 
  Select the use case Dev/Test.
  License model – leave default
  DB Engine version – leave default at PostgreSQL 10.6-r1
  Check the Only enable options eligible for RDS free Usage Tier
  DB Instance class – leave default. Only 1 option available.
  Allocated Storage. You don't need much.
  Provide a DB Instance Identifier unique for your Account ________________________________________
  
  Set a Maser user name ________________________________
  
  Set Master password _______________________
  Virtual Private Cloud: leave Default
  Subnet Default
  Public Accessibility:  YES YES YES YES YES
  VPC Security Group: create new VPC security group
  Database name:  codefellowship
  Port:  leave default of 5432
  DB Parameter Group:  leave default
  IAM DB authentication:  Disable
  Backup: 0 Days
  Uncheck Copy tags to snapshots
  Disable Enhanced Monitoring
  Disable performance insights
  If checked, uncheck pushing all logs to Amazon CloudWatch Logs
  Disable auto minor version upgrade
  Maintenance window: no preference
  Deletion protection:  your choice.  Will have to disable before deleting if you enable.
  Click Create Database

  ```
1. Still in the AWS console, go to RDS > Databases > yourdatabase. Under "Connectivity and Security", click on the listing under "VPC Security Groups". At the bottom of that security group page, click the "Inbound" tab, then click "Edit". In that modal, click "Add Rule". Pick PostgreSQL in the first dropdown, and "Anywhere" in the second dropdown. Click "Save".
2. Set up your web app to use an environment variable for the database URL, username, and password. For Java apps, this will mean modifying the `spring.datasource.url, spring.datasource.username, spring.datasource.password` lines in your `application.properties` file. While in that file, also ensure the line `server.port=5000` is present (so your app will run on port 5000, where Elastic Beanstalk expects), and also check that the `ddl-auto` line is set as necessary. As an example, your `application.properties` file might look like:
    ```
    spring.datasource.url=${DATABASE_URL}
    spring.datasource.username=${DATABASE_USERNAME}
    spring.datasource.password=${DATABASE_PASSWORD}
    server.port=5000
    spring.jpa.hibernate.ddl-auto=update
    ```
3. Run `./gradlew bootJar` to generate the .jar file for your app. It generates in `build/libs`.
4. Run `eb init` to initialize your elasticbeanstalk app.
  - If you discover that you don't have `eb` installed on your machine, run `brew install awsebcli`. For your access keys, you'll need to create an IAM user in the AWS console, and add their `aws-access-id` and `aws-secret-key` to `eb`.
5. Run `eb create --single` to set up an elasticbeanstalk environment. (The `--single` ensures that you don't create a load balancer, because load balancers cost money.)
5. In the new `.elasticbeanstalk/config.yml` file that appears, add these lines with NO indentation at the first line:
    ```
    deploy:
      artifact: build/libs/<your-file-name>.jar
    ```
6. Run `eb deploy` to perform an initial deployment of your application. It won't be working yet. That's okay.
<!-- 6. Go into the AWS Console (online) and find the security group ID for your EC2 instance. (It starts with `sg-` and can be found in several places, including the Elastic Beanstalk configuration page.) Copy this string and switch to the RDS console, and find your Postgres instance. Click on the VCS group for that database, and add the security group as an allowed Postgres connection. -->
7. Run `eb setenv DATABASE_URL=jdbc:postgresql://whateverawssaid.for.rds.02.17.com/TheDatabaseNameYouSet DATABASE_USERNAME=TheUsernameYouSet DATABASE_PASSWORD=ThePasswordYouSet`. This sets the environment variables you specified in your `application.properties` file on the EC2 instance that Elastic Beanstalk created for you.
  - You can also try setting these environment variables locally to run your server locally, but pointing at your RDS database.
8. Run `eb deploy` again. This pushes your .jar file onto your EC2 instance and starts it running; the instance will automatically look for it on port 5000.
9. Use `eb open` (or `eb status` and go to the URL listed next to `CNAME`) to visit your deployed site!
10. If anything has gone wrong, use `eb logs` or look at the logs on the console to figure out what's not working.
