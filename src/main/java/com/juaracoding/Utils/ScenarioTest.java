package com.juaracoding.Utils;

public enum ScenarioTest {
//    Management Unit Test Scenario
    T1("I Filter Unit Data"),
    T2("I reset unit after filter data"),
    T3("I added valid data unit"),
    T4("I added and did not fill in the data unit name"), //Negative Test
    T5("I added and did not fill in the data lokasi tetap aturan cuti and unit kalender"),
    T6("I added a new shift"),
    T7("I added a new shift but no input shift name"),
    T8("I added additional work hours"),
    T9("I added additional work hours but not input shifting"),
    T10("I delete additional work hours"),
    T11("Im  not input virtual id"),
    T12("I uploaded a file that exceeds the capacity."),
    T13("I input virtual id"),

    //Management User Test Scenario
    T14("I Filter User Data");


    private String scenarioTestName;

    ScenarioTest(String value){

        scenarioTestName = value;
    }

    public String getScenarioTestName() {

        return scenarioTestName;
    }
}
