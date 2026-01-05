
# My Gilded Rose Refactoring Solution (Java)

This repository contains my solution to the **Gilded Rose Refactoring Kata Implemented in Java**.

### Approach
- Added characterization tests to lock existing behavior
- Refactored the code in small, safe steps
- Implemented the new Conjured items feature last

### How to run tests  
From the `Java` directory:  
`.\gradlew.bat test`  
On Mac/Linux:  
`./gradlew test`

## Test-first process and coverage

I followed a **test-first (characterization) approach**, adding tests in the same
order as the requirements listed in the Gilded Rose specification.

Each test focuses on a **single business rule** and was written **before
refactoring or introducing new functionality**.

### Tests added (in requirement order)

- **normalItem_decreasesSellInAndQualityByOne**  
  Verifies that a normal item decreases both `sellIn` and `quality` by 1 per day.

- **normalItem_afterSellDate_degradesQualityTwiceAsFast**  
  Verifies that once the sell-by date has passed, a normal item’s quality
  degrades twice as fast.

- **qualityNeverNegative**  
  Ensures that an item’s quality never drops below 0.

- **agedBrie_increasesQualityOverTime**  
  Verifies that *Aged Brie* increases in quality as it gets older.

- **qualityNeverAboveFifty**  
  Ensures that an item’s quality never exceeds 50.

- **sulfuras_neverChanges**  
  Verifies that *Sulfuras* never changes in quality or sell-in value
  (and retains a quality of 80).

- **backStagePass_IncreaseQualityWhenMoreThan10Days**  
  Verifies that *Backstage passes* increase in quality by 1 when more than
  10 days remain before the concert.

- **backStagePass_IncreaseQualityWhen10DaysOrLess**  
  Verifies that *Backstage passes* increase in quality by 2 when 10 days or less
  remain before the concert.

- **backStagePass_IncreaseQualityWhen5DaysOrLess**  
  Verifies that *Backstage passes* increase in quality by 3 when 5 days or less
  remain before the concert.

- **backStagePass_QualityDropsToZeroAfterConcert**  
  Verifies that *Backstage passes* drop to a quality of 0 after the concert date.
  
(at this stage I refactored and cleaned the code in GildedRose.java and then added the conjured items tests followed by a refactoring of the code to implement the conjured items rules)

- **conjured_degradesTwiceAsFast**  
  Verifies that *Conjured* items degrade in quality twice as fast as normal items.

- **conjured_afterSellDate_degradesTwiceAsFastAgain**  
  Verifies that *Conjured* items degrade twice as fast again once the sell-by
  date has passed.

This test suite provides full coverage of the core business rules and acts as a
safety net for refactoring and feature development.



   
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
