package control.self.igor.algorithms.service.test.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.DurationWithUnit;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithm;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithms;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.algorithm.general.SumTwoNumbersAlgorithmService;
import control.self.igor.algorithms.service.problem.general.SumTwoNumbersProblemService;
import control.self.igor.algorithms.service.report.general.SumTwoNumbersReportService;

@Service
public class GeneralAlgorithmsTestServiceImpl implements GeneralAlgorithmsTestService {

    private SumTwoNumbersProblemService sumTwoNumbersProblemService;
    private SumTwoNumbersAlgorithmService sumTwoNumbersAlgorithmService;
    private SumTwoNumbersReportService sumTwoNumbersReportService;

    @Autowired
    public GeneralAlgorithmsTestServiceImpl(SumTwoNumbersProblemService sumTwoNumbersProblemService,
	    SumTwoNumbersAlgorithmService sumTwoNumbersAlgorithmService,
	    SumTwoNumbersReportService sumTwoNumbersReportService) {
	this.sumTwoNumbersProblemService = sumTwoNumbersProblemService;
	this.sumTwoNumbersAlgorithmService = sumTwoNumbersAlgorithmService;
	this.sumTwoNumbersReportService = sumTwoNumbersReportService;
    }

    @Override
    public AlgorithmsTestsReport testSumTwoNumbersAlgorithm(int testsNumber) {
	List<TwoNumbersAsArrays> problems = sumTwoNumbersProblemService.createProblems(testsNumber);
	long startTime = System.nanoTime();
	List<SolvedAlgorithm<TwoNumbersAsArrays, int[]>> solvedSumTwoNumbersAlgorithms = solveSumsTwoNumbers(problems);
	long endTime = System.nanoTime();
	DurationWithUnit findingAllSolutionsDuration = DurationWithUnit.createMillisFromNanos(endTime - startTime);
	SolvedAlgorithms<TwoNumbersAsArrays, int[]> solvedAlgorithms = new SolvedAlgorithms<>(
		findingAllSolutionsDuration, solvedSumTwoNumbersAlgorithms);
	return sumTwoNumbersReportService.createReport(solvedAlgorithms);
    }

    private List<SolvedAlgorithm<TwoNumbersAsArrays, int[]>> solveSumsTwoNumbers(List<TwoNumbersAsArrays> problems) {
	List<SolvedAlgorithm<TwoNumbersAsArrays, int[]>> solvedSumTwoNumbersAlgorithms = new ArrayList<>();
	for (TwoNumbersAsArrays problem : problems) {
	    solvedSumTwoNumbersAlgorithms.add(solveSumTwoNumbers(problem));
	}
	return solvedSumTwoNumbersAlgorithms;
    }

    private SolvedAlgorithm<TwoNumbersAsArrays, int[]> solveSumTwoNumbers(TwoNumbersAsArrays problem) {
	long startTime = System.nanoTime();
	int[] solution = sumTwoNumbersAlgorithmService.solve(problem);
	long endTime = System.nanoTime();
	DurationWithUnit findingSolutionDuration = DurationWithUnit.createMicrosFromNanos(endTime - startTime);
	return new SolvedAlgorithm<TwoNumbersAsArrays, int[]>(problem, solution, findingSolutionDuration);
    }

}
