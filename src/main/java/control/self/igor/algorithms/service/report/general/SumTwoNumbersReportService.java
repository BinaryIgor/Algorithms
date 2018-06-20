package control.self.igor.algorithms.service.report.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.DurationWithUnit;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithm;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithms;
import control.self.igor.algorithms.model.problem.TwoNumbers;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.report.AlgorithmTestReport;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.report.AlgorithmReportService;

@Service
public class SumTwoNumbersReportService implements AlgorithmReportService<TwoNumbersAsArrays, int[]> {

    @Override
    public AlgorithmTestReport createReport(SolvedAlgorithm<TwoNumbersAsArrays, int[]> solvedAlgorithm) {
	String problemReport = reportProblem(solvedAlgorithm.getProblem());
	String solutionReport = reportSolution(solvedAlgorithm.getSolution());
	String durationReport = reportDuration(solvedAlgorithm.getFindingSolutionDuration());
	return new AlgorithmTestReport(solvedAlgorithm.getName(), problemReport, solutionReport, durationReport);
    }

    @Override
    public AlgorithmsTestsReport createReport(SolvedAlgorithms<TwoNumbersAsArrays, int[]> solvedAlgorithms) {
	List<AlgorithmTestReport> reports = new ArrayList<>();
	for (SolvedAlgorithm<TwoNumbersAsArrays, int[]> solvedAlgorithm : solvedAlgorithms.getSolvedAlgorithms())
	    reports.add(createReport(solvedAlgorithm));
	String generalReport = reportGeneral(solvedAlgorithms);
	return new AlgorithmsTestsReport(generalReport, reports);
    }

    private String reportProblem(TwoNumbers<int[]> problem) {
	return "Find sum of = " + numberToString(problem.getFirst()) + " + " + numberToString(problem.getSecond());
    }

    private String reportSolution(int[] solution) {
	return "Found sum = " + numberToString(solution);
    }

    private String reportDuration(DurationWithUnit findingSolutionDuration) {
	return "Finding solution took " + findingSolutionDuration.getDuration() + " "
		+ findingSolutionDuration.getUnit();
    }

    private String reportGeneral(SolvedAlgorithms<TwoNumbersAsArrays, int[]> solvedAlgorithms) {
	return "Solving " + solvedAlgorithms.getSolvedAlgorithms().size() + " problems took "
		+ solvedAlgorithms.getFindingAllSolutionsDuration().getDuration() + " "
		+ solvedAlgorithms.getFindingAllSolutionsDuration().getUnit();
    }

    private String numberToString(int[] number) {
	StringBuilder builder = new StringBuilder();
	number = removeLeadingZeros(number);
	for (int digit : number)
	    builder.append(String.valueOf(digit));
	return builder.toString();
    }

    private int[] removeLeadingZeros(int[] number) {
	if (number[0] != 0 || number.length == 1)
	    return number;
	int newFirstIndex = 1;
	for (int i = 1; i < number.length - 1; i++)
	    if (number[i] != 0)
		break;
	    else
		++newFirstIndex;
	return Arrays.copyOfRange(number, newFirstIndex, number.length);
    }

}
