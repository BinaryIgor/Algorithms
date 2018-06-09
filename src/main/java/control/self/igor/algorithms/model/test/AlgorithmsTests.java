package control.self.igor.algorithms.model.test;

import java.util.List;

import control.self.igor.algorithms.model.DurationWithUnit;

public class AlgorithmsTests<Problem, Solution> {

    private DurationWithUnit allTestsDuration;
    private List<AlgorithmTest<Problem, Solution>> tests;

    public AlgorithmsTests(DurationWithUnit allTestsDuration, List<AlgorithmTest<Problem, Solution>> tests) {
	this.allTestsDuration = allTestsDuration;
	this.tests = tests;
    }

    public DurationWithUnit getAllTestsDuration() {
	return allTestsDuration;
    }

    public List<AlgorithmTest<Problem, Solution>> getTests() {
	return tests;
    }

}
