## TestNG framework template

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
mvn clean test -DtestNGXml=testSuites/integration.xml
```