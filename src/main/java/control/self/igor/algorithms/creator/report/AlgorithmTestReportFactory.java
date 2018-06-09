package control.self.igor.algorithms.creator.report;

import control.self.igor.algorithms.exception.CreatorException;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.test.AlgorithmTest;
import control.self.igor.algorithms.model.test.AlgorithmTestReport;
import control.self.igor.algorithms.model.test.AlgorithmsTests;
import control.self.igor.algorithms.model.test.AlgorithmsTestsReports;

public class AlgorithmTestReportFactory {

    public static <Problem, Solution> AlgorithmTestReport create(Class<Problem> problemClazz,
	    Class<Solution> solutionClazz, AlgorithmTest<Problem, Solution> algorithmTest) {

	return null;
    }

    public static <Problem, Solution> AlgorithmsTestsReports create(Class<Problem> problemClazz,
	    Class<Solution> solutionClazz, AlgorithmsTests<Problem, Solution> algorithmsTests) {
	return null;
    }

    public static <Problem, Solution> AlgorithmTestReportCreator getCreator(Class<Problem> problemClazz,
	    Class<Solution> solutionClazz) {
	if (problemClazz.isAssignableFrom(TwoNumbersAsArrays.class))
	    return new SumTwoNumbersTestReportCreator();
	throw CreatorException.createLackOfCreatorException(problemClazz);
    }
}
