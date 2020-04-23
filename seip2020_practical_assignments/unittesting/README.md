# 3rd Assignment: Unit Testing

This module aims to run multiple kinds of tests (JUnit) in multiple ways for arithmetic and non-arithmetic operations:

_Arithmetic tests_
* Division
* Multiplication
* Factorial
* Prime numbers

_File test_
* Searching file

After you have built the project following the [steps](https://github.com/LoukasPap/seipCourse_2020/blob/development/README.md) in the first README.md, continue below to run the tests.

## Test project
To simply run all the unit tests, execute from command line
`mvn test`

## Generate Test-coverage report
To simply run the unit tests of the project, with jacoco report, execute the following Maven command: 
```
mvn test jacoco:report
```
## Continuous Integration service
This projects utilizes TravisCI services in other to test and build the application upon each ```git-push``` in the remote repository. 
There are multiple build environments in which the application will be tested and build. You can check these options under the ```jdk``` tag in the ```.travis.yml``` file. 

After each build, the badge is updated with the corresponding build status, ```green``` for passes and ```red``` for failures.

[Here](https://docs.travis-ci.com/user/getting-started/) is a TravisCI quick guide. It's free for public repositories! 

## Code coverage service
The repository is connected to a **code coverage** analysis tools, [CodeCov](https://codecov.io/). Code coverage service provides a badge with the coverage percentages.

### CodeCov
Code coverage reports provided by CodeCov is available on the repository page in the CodeCov website. The analysis is executed after each successfully TravisCI build. 

CodeCov can use a more elaborated code coverage report that is produced by including the following plugin in your POM file. 
```
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>cobertura-maven-plugin</artifactId>
	<version>2.7</version>
	<configuration>
		<formats>
			<format>html</format>
			<format>xml</format>
		</formats>
		<check />
	</configuration>
</plugin>
```
In order to produce the cobertura coverage report include the ```cobertura:cobertura``` in your ```mvn``` command.

The command for triggering the code coverage analysis should be placed in the ```.travis.yml``` as illustrated below
```
after_success:
  - bash <(curl -s https://codecov.io/bash) -t your_token 
```
The ```-t your_token``` is required only for private respositories. 

In order to obtain a badge [![codecov](https://codecov.io/gh/LoukasPap/seipCourse_2020/branch/master/graph/badge.svg?token=AL0BBLBUMQ)](https://codecov.io/gh/LoukasPap/seipCourse_2020) in your README that reports the coverage of your project, copy-paste the Markdown link provided by CodeCov in the repository's ```Settings-->Badge-->Markdown```. Note that if you have a private repository the badge requires a ```?token=a_token``` variable in the provided url. Otherwise it will always shows "unknown". 

[Here](https://github.com/codecov/example-java) is a short example for using CodeCov with TravisCI in a Java project.

## Acknowledgments
* Lots blocks of code taken from this [repository](https://github.com/AntonisGkortzis/BuildAutomationToolsDemoProject)
