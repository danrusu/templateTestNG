## JDK8 TestNG framework template 

#### 1. Test Execution 
- Run all unit, integration, end2end tests from [all.xml](./testSuites/all.xml)
```bash
mvn clean test 
```

- Run tests filtering by groups
```bash
mvn clean test -Dgroups=integration,end2end
```

- Run tests from different testNG suite XML
```bash
mvn clean test -DtestNGXml=testSuites/end2end.xml -Dgroups=api
```

***

#### 2. Tech stack
- [Java JDK8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven 3](https://maven.apache.org/) 
- [TestNG](https://testng.org/doc/) - test runner
- [Log4j2](https://logging.apache.org/log4j/2.x/) - logging
- [AssertJ](https://assertj.github.io/doc/) - fluent assertions
- [RestAssured](https://rest-assured.io/) - API testing
- [Lombok](https://projectlombok.org/features/all)
- [Vavr.io](https://www.vavr.io/)

***

#### 3. Project structure 
- [maven POM](./pom.xml)
- [logger configuration](./src/test/resources/log4j2.xml)
- [testNG XML suites](./testSuites)

***

#### 4. Resources
- TestNG
  - [Documentation](https://testng.org/doc/documentation-main.html)
  - [Parallel tests](https://testng.org/doc/documentation-main.html#parallel-tests)