package control.self.igor.algorithms.service.test.general;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.AlgorithmTestService;

@Service
public class GeneralAlgorithmsTestServiceImpl implements GeneralAlgorithmsTestService {

    private AlgorithmTestService<TwoNumbersAsArrays, int[]> sumTwoNumbersTestService;
    private AlgorithmTestService<TwoNumbersAsIntegers, Integer> greatestCommonDivisorAlgorithmTestService;
    private AlgorithmTestService<TwoNumbersAsIntegers, Integer> lowestCommonMultipleAlgorithmTestService;

    public GeneralAlgorithmsTestServiceImpl(AlgorithmTestService<TwoNumbersAsArrays, int[]> sumTwoNumbersTestService,
	    @Qualifier("GreatestCommonDivisorAlgorithmTestService") AlgorithmTestService<TwoNumbersAsIntegers, Integer> greatestCommonDivisorAlgorithmTestService,
	    @Qualifier("LowestCommonMultipleAlgorithmTestService") AlgorithmTestService<TwoNumbersAsIntegers, Integer> lowestCommonMultipleAlgorithmTestService) {
	this.sumTwoNumbersTestService = sumTwoNumbersTestService;
	this.greatestCommonDivisorAlgorithmTestService = greatestCommonDivisorAlgorithmTestService;
	this.lowestCommonMultipleAlgorithmTestService = lowestCommonMultipleAlgorithmTestService;
    }

    @Override
    public AlgorithmsTestsReport testSumTwoNumbersAlgorithm(int testsNumber, int maximalNumberLength) {
	return sumTwoNumbersTestService.testAlgorithm(testsNumber, maximalNumberLength);
    }

    @Override
    public AlgorithmsTestsReport testGreatestCommonDivisorAlgorithm(int testsNumber, int maxNumberValue) {
	return greatestCommonDivisorAlgorithmTestService.testAlgorithm(testsNumber, maxNumberValue);
    }

    @Override
    public AlgorithmsTestsReport testLowestCommonMultipleAlgorithm(int testsNumber, int maxNumberValue) {
	return lowestCommonMultipleAlgorithmTestService.testAlgorithm(testsNumber, maxNumberValue);
    }

}
