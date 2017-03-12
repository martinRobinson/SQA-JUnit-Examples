SQA-JUnit-Examples
================
This is a simple gradle project which illustrates the use of the gradle build system within Exclipse 
and using integrations such as Travis Continuous Integration and CodeCov coverage of Junit tests.
Notable points about the project:

1. The project was created from scratch using the new project from gradle - if you have downloaded the full Java developers version of Eclipse then you will already have gradle buildship and eGit installed otherwise you will need to install it from eclipse marketplace.
2. Once the standard gradle project has been created, I then created an empty GitHub repository. I then created a local GitHub repository for the project and uploaded it to the GitHub repo. 
3. I deleted the local copy of the project and cloned the GitHub repo of the project into Eclipse.
4. I then added my SUT classes and test classes into the appropriate sub-directories under source.
5. I configured the gradle build configuration and verified that gradle could correctly build and test the project.
6. I created the .travis.yml file for the project and committed it to the GitHub repo.
7. I then enabled the travis and codecov integrations.
8. On the next commit I was able to verify that continuous integration and code coverage had taken place.

And then thereafer I added more Junit tests.



