package control.self.igor.algorithms.service.test;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;

public interface AlgorithmTestService<Problem, Solution> {

    AlgorithmsTestsReport testAlgorithm(int testsNumber, int problemSize);

}
