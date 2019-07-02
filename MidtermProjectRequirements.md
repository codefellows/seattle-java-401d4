# Midterm Project Requirements

Your midterm project must use Java to build an interesting, well-thought-out, complete application.

Specifically, you must:

1. Build a RESTful API that is a usable product.
    - Must have at least 2 models, likely related, with data stored in a database.
    - Must have views for HTML, JSON, or any combination of the two.
    - Must have at least 2 controller files, with full CRUD on at least one resource.
    - Should most likely contain Auth using Spring. (This is useful for both web apps and APIs.)
        - Exception: if you really want to build something hardware-related instead of a web app

2. Document your application.
    - Include a README.md file with:
        - An overview of the application and its functionality
        - Screenshots of the application
        - A link to the deployed application
        - A list of technologies used in the application
        - Directions to clone the repo and get the application running on your own computer
        - Links to each team member's GitHub profile
    - Include relevant comments in your code.
        - Do NOT include irrelevant comments or dead code in your application.

3. Test your application.
    - Must contain unit tests for constructors/getters/setters.
    - Must contain unit tests for any logic or utility methods.
    - Must contain integration tests for at least all GET request endpoints.
    - Must contain at LEAST one end to end test that creates a resource, then reads that resource and ensures that it was saved correctly.

4. Deploy your application to the world.
    - Your application must be available online, using EC2 and RDS.
