package control.self.igor.algorithms.service.report;

import control.self.igor.algorithms.model.algorithm.SolvedAlgorithm;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithms;
import control.self.igor.algorithms.model.report.AlgorithmTestReport;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;

public interface AlgorithmReportService<Problem, Solution> {

    AlgorithmTestReport createReport(SolvedAlgorithm<Problem, Solution> solvedAlgorithm);

    AlgorithmsTestsReport createReport(SolvedAlgorithms<Problem, Solution> solvedAlgorithms);
}
