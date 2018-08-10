package control.self.igor.algorithms.service.test.general;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;

public interface GeneralAlgorithmsTestService {

    AlgorithmsTestsReport testSumTwoNumbersAlgorithm(int testsNumber, int maximalNumberLength);

    AlgorithmsTestsReport testGreatestCommonDivisorAlgorithm(int testsNumber, int maxNumberValue);

    AlgorithmsTestsReport testLowestCommonMultipleAlgorithm(int testsNumber, int maxNumberValue);
}