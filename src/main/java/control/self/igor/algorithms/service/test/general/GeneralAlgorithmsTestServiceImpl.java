package control.self.igor.algorithms.service.test.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.algorithm.general.SumTwoNumbersAlgorithm;
import control.self.igor.algorithms.creator.problem.ProblemFactory;
import control.self.igor.algorithms.creator.report.SumTwoNumbersTestReportCreator;
import control.self.igor.algorithms.model.DurationWithUnit;
import control.self.igor.algorithms.model.problem.TwoNumbers;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.test.AlgorithmTest;
import control.self.igor.algorithms.model.test.AlgorithmsTests;
import control.self.igor.algorithms.model.test.AlgorithmsTestsReports;

@Service
public class GeneralAlgorithmsTestServiceImpl implements GeneralAlgorithmsTestService {

    @Override
    public AlgorithmsTestsReports testSumTwoNumbersAlgorithm(int testsNumber) {
	List<TwoNumbersAsArrays> problems = ProblemFactory.create(TwoNumbersAsArrays.class, testsNumber);
	List<AlgorithmTest<TwoNumbers<int[]>, int[]>> sumTwoNumbersTests = new ArrayList<>();
	long startTime = System.nanoTime();
	for (TwoNumbers<int[]> problem : problems)
	    sumTwoNumbersTests.add(testSumTwoNumbers(problem));
	long endTime = System.nanoTime();
	DurationWithUnit findingAllSolutionsDuration = DurationWithUnit.createMillisFromNanos(endTime - startTime);
	return createReports(
		new AlgorithmsTests<TwoNumbers<int[]>, int[]>(findingAllSolutionsDuration, sumTwoNumbersTests));
    }

    private AlgorithmsTestsReports createReports(AlgorithmsTests<TwoNumbers<int[]>, int[]> algorithmsTests) {
	SumTwoNumbersTestReportCreator creator = new SumTwoNumbersTestReportCreator();
	return creator.create(algorithmsTests);
    }

    private AlgorithmTest<TwoNumbers<int[]>, int[]> testSumTwoNumbers(TwoNumbers<int[]> problem) {
	long startTime = System.nanoTime();
	SumTwoNumbersAlgorithm algorithm = new SumTwoNumbersAlgorithm(problem);
	int[] solution = algorithm.solve();
	long endTime = System.nanoTime();
	DurationWithUnit findingSolutionDuration = DurationWithUnit.createMicrosFromNanos(endTime - startTime);
	return new AlgorithmTest<TwoNumbers<int[]>, int[]>(problem, solution, findingSolutionDuration);
    }

}
