package control.self.igor.algorithms.service.report.general;

import java.util.ArrayList;
import java.util.List;

import control.self.igor.algorithms.model.algorithm.SolvedAlgorithm;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithms;
import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.model.report.AlgorithmTestReport;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.report.AlgorithmReportService;

public class CommonNumberReportService implements AlgorithmReportService<TwoNumbersAsIntegers, Integer> {

    private Mode mode;

    public CommonNumberReportService(Mode mode) {
	this.mode = mode;
    }

    @Override
    public AlgorithmTestReport createReport(SolvedAlgorithm<TwoNumbersAsIntegers, Integer> solvedAlgorithm) {
	String problemReport = reportProblem(solvedAlgorithm.getProblem());
	String solutionReport = reportSolution(solvedAlgorithm.getSolution());
	String durationReport = solvedAlgorithm.getFindingSolutionDuration().toString();
	return new AlgorithmTestReport(solvedAlgorithm.getName(), problemReport, solutionReport, durationReport);
    }

    private String reportProblem(TwoNumbersAsIntegers problem) {
	String base = "Find ";
	if (mode.equals(Mode.GREATEST_COMMON_DIVISOR)) {
	    base += "the Greatest Common Divisor ";
	} else {
	    base += "the Lowest Common Multiple ";
	}
	return base + "of " + problem.getFirst() + " and " + problem.getSecond();
    }

    private String reportSolution(Integer solution) {
	String base = mode.equals(Mode.GREATEST_COMMON_DIVISOR) ? "The Greatest Common Divisor"
		: "The Lowest Common Multiple";
	return base + " = " + solution;
    }

    @Override
    public AlgorithmsTestsReport createReport(SolvedAlgorithms<TwoNumbersAsIntegers, Integer> solvedAlgorithms) {
	List<AlgorithmTestReport> reports = new ArrayList<>();
	for (SolvedAlgorithm<TwoNumbersAsIntegers, Integer> solvedAlgorithm : solvedAlgorithms.getSolvedAlgorithms()) {
	    reports.add(createReport(solvedAlgorithm));
	}
	String generalReport = reportGeneral(solvedAlgorithms);
	return new AlgorithmsTestsReport(generalReport, reports);
    }

    private String reportGeneral(SolvedAlgorithms<TwoNumbersAsIntegers, Integer> solvedAlgorithms) {
	return "Solving " + solvedAlgorithms.getSolvedAlgorithms().size() + " problems took "
		+ solvedAlgorithms.getFindingAllSolutionsDuration();
    }

    public enum Mode {
	GREATEST_COMMON_DIVISOR, LOWEST_COMMON_MULTLIPLE
    }
}
