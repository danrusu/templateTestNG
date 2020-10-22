## TestNG framework template

#### 1. Test Execution 
- Run all unit, integration, end2end tests from [all.xml](./testSuites/all.xml)
```bash
mvn clean test 
```

- Run tests filtering by groups
```bash
mvn clean test -Dgroups=integration,end2end
```

- Run tests from different testNG suite xml
```bash
mvn clean test -DtestNGXml=testSuites/end2end.xml
```

#### 2. Project structure 
- under construction

#### 3. Resources
- TestNG
  - [Documentation](https://testng.org/doc/documentation-main.html)
  - [Parallel tests](https://testng.org/doc/documentation-main.html#parallel-tests)