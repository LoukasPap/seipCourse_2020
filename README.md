# seipCourse_2020
Software Engineering in Practise Course | 2020

This is a private repository for delivering all the assignments of the course "Software Engineering in Practise".

# 2nd Assignment: HistogramGenerator

Here, the executable .jar takes a path as a parameter. This path must lead to text file (.txt), that has each grade of a student in a separate line. Then, the frequency of the grades is counted and stored into a one-dimension array. At last, after reading this array, a diagram is being created, presenting the frequency of each grade.

### Prerequisites

1. Version 1.8 of JDK. Also check if the environment variable has the right path.
2. A text file with one grade in each line.

## Building & Running

1. __Fork__ the repository.
 
2. __Clone__ the forked repository.
 `git clone <url>`, where _url_ is the url of your forked repository.

4. If you have Maven setted up, follow the steps below. If you have not, check the _Acknowledgments_ section at the bottom.

   __Execute__ `mvn install`

5. The produced jar is located in the target directory and can be executed as following:
   
   `java -jar <pathOfJar> <pathOfTextFile>`

where _pathOfJar_ is the location of the downloaded .jar file, and _pathOfTextFile_ is the location of the text file.

Make sure your text file has each grade in separate lines.


## Running the tests

No tests done yet.

### Break down into end to end tests

No tests done yet.

### And coding style tests

No tests done yet.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse](https://www.eclipse.org/) - IDE for Java

## Contributing

No contributions are allowed yet.

## Authors

* **Loukas Papadopoulos** - *Initial work* - [LoukasPap](https://github.com/LoukasPap)

## License

This project has no lisence.

## Acknowledgments

* Lots blocks of code taken from this [repository](https://github.com/AntonisGkortzis/BuildAutomationToolsDemoProject)
* How to setup Maven in Windows - [tutorial](https://mkyong.com/maven/how-to-install-maven-in-windows/)