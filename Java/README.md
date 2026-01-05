
# My Gilded Rose Refactoring Solution (Java)

This repository contains my solution to the **Gilded Rose Refactoring Kata (Java)**.

### Approach
- Added characterization tests to lock existing behavior
- Refactored the code in small, safe steps
- Implemented the new **Conjured items** feature last

### How to run tests
From the `java` directory on Windows:
        .\gradlew.bat test
On Mac/Linux:
        ./gradlew test


# Gilded Rose starting position in Java

## Run the TextTest Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).


## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. The first uses Gradle wrapped in a python script. Uncomment these lines to use it:

    executable:${TEXTTEST_HOME}/Java/texttest_rig.py
    interpreter:python

The other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr). Uncomment these lines to use it instead:

    executable:com.gildedrose.TexttestFixture
    interpreter:java
