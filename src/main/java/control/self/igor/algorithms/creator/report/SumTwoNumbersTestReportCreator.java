package control.self.igor.algorithms.creator.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import control.self.igor.algorithms.model.DurationWithUnit;
import control.self.igor.algorithms.model.problem.TwoNumbers;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.test.AlgorithmTest;
import control.self.igor.algorithms.model.test.AlgorithmTestReport;
import control.self.igor.algorithms.model.test.AlgorithmsTests;
import control.self.igor.algorithms.model.test.AlgorithmsTestsReports;

public class SumTwoNumbersTestReportCreator implements AlgorithmTestReportCreator<TwoNumbersAsArrays, int[]> {

    @Override
    public AlgorithmTestReport create(AlgorithmTest<TwoNumbersAsArrays, int[]> test) {
	String problemReport = reportProblem(test.getProblem());
	String solutionReport = reportSolution(test.getSolution());
	String durationReport = reportDuration(test.getFindingSolutionDuration());
	return new AlgorithmTestReport(problemReport, solutionReport, durationReport);
    }

    @Override
    public AlgorithmsTestsReports create(AlgorithmsTests<TwoNumbersAsArrays, int[]> tests) {
	List<AlgorithmTestReport> reports = new ArrayList<>();
	for (AlgorithmTest<TwoNumbersAsArrays, int[]> test : tests.getTests())
	    reports.add(create(test));
	String generalReport = reportGeneral(tests);
	return new AlgorithmsTestsReports(generalReport, reports);
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

    private String reportGeneral(AlgorithmsTests<TwoNumbersAsArrays, int[]> tests) {
	return "Solving " + tests.getTests().size() + " problems took " + tests.getAllTestsDuration().getDuration()
		+ " " + tests.getAllTestsDuration().getUnit();
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
