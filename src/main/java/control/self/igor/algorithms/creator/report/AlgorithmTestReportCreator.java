package control.self.igor.algorithms.creator.report;

import control.self.igor.algorithms.model.test.AlgorithmTest;
import control.self.igor.algorithms.model.test.AlgorithmTestReport;
import control.self.igor.algorithms.model.test.AlgorithmsTests;
import control.self.igor.algorithms.model.test.AlgorithmsTestsReports;

public interface AlgorithmTestReportCreator<Problem, Solution> {

    AlgorithmTestReport create(AlgorithmTest<Problem, Solution> test);

    AlgorithmsTestsReports create(AlgorithmsTests<Problem, Solution> tests);
}
