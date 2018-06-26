package control.self.igor.algorithms.service.report.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.DurationWithUnit;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithm;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithms;
import control.self.igor.algorithms.model.report.AlgorithmTestReport;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.report.AlgorithmReportService;

@Service
public class SortingAlgorithmReportService implements AlgorithmReportService<List<Integer>, List<Integer>> {

    @Override
    public AlgorithmTestReport createReport(SolvedAlgorithm<List<Integer>, List<Integer>> solvedAlgorithm) {
	String problemReport = reportProblem(solvedAlgorithm.getProblem());
	String solutionReport = reportSolution(solvedAlgorithm.getSolution());
	String durationReport = reportDuration(solvedAlgorithm.getFindingSolutionDuration());
	return new AlgorithmTestReport(solvedAlgorithm.getName(), problemReport, solutionReport, durationReport);
    }

    private String reportProblem(List<Integer> problem) {
	return "Sorting of list: " + problem;
    }

    private String reportSolution(List<Integer> solution) {
	return "Sorted list: " + solution;
    }

    private String reportDuration(DurationWithUnit duration) {
	return "Finding solution took: " + duration;
    }

    @Override
    public AlgorithmsTestsReport createReport(SolvedAlgorithms<List<Integer>, List<Integer>> solvedAlgorithms) {
	List<AlgorithmTestReport> testsReports = new ArrayList<>();
	for (SolvedAlgorithm<List<Integer>, List<Integer>> solvedAlgorithm : solvedAlgorithms.getSolvedAlgorithms()) {
	    testsReports.add(createReport(solvedAlgorithm));
	}
	String generalReport = reportGeneral(solvedAlgorithms);
	return new AlgorithmsTestsReport(generalReport, testsReports);
    }

    private String reportGeneral(SolvedAlgorithms<List<Integer>, List<Integer>> solvedAlgorithms) {
	return "Solving " + solvedAlgorithms.getSolvedAlgorithms().size() + " sorting problems took: "
		+ solvedAlgorithms.getFindingAllSolutionsDuration();
    }

}
