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
import control.self.igor.algorithms.util.StringUtil;

@Service
public class SortingAlgorithmReportService implements AlgorithmReportService<int[], int[]> {

    @Override
    public AlgorithmTestReport createReport(SolvedAlgorithm<int[], int[]> solvedAlgorithm) {
	String problemReport = reportProblem(solvedAlgorithm.getProblem());
	String solutionReport = reportSolution(solvedAlgorithm.getSolution());
	String durationReport = reportDuration(solvedAlgorithm.getFindingSolutionDuration());
	return new AlgorithmTestReport(solvedAlgorithm.getName(), problemReport, solutionReport, durationReport);
    }

    private String reportProblem(int[] problem) {
	return "Sorting of list: " + StringUtil.arrayToString(problem);
    }

    private String reportSolution(int[] solution) {
	return "Sorted list: " + StringUtil.arrayToString(solution);
    }

    private String reportDuration(DurationWithUnit duration) {
	return "Finding solution took: " + duration;
    }

    @Override
    public AlgorithmsTestsReport createReport(SolvedAlgorithms<int[], int[]> solvedAlgorithms) {
	List<AlgorithmTestReport> testsReports = new ArrayList<>();
	for (SolvedAlgorithm<int[], int[]> solvedAlgorithm : solvedAlgorithms.getSolvedAlgorithms()) {
	    testsReports.add(createReport(solvedAlgorithm));
	}
	String generalReport = reportGeneral(solvedAlgorithms);
	return new AlgorithmsTestsReport(generalReport, testsReports);
    }

    private String reportGeneral(SolvedAlgorithms<int[], int[]> solvedAlgorithms) {
	return "Solving " + solvedAlgorithms.getSolvedAlgorithms().size() + " sorting problems took: "
		+ solvedAlgorithms.getFindingAllSolutionsDuration();
    }

}
