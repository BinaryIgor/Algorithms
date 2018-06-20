package control.self.igor.algorithms.service.test.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.AlgorithmTestService;

@Service
public class GeneralAlgorithmsTestServiceImpl implements GeneralAlgorithmsTestService {

    private AlgorithmTestService<TwoNumbersAsArrays, int[]> sumTwoNumbersTestService;

    @Autowired
    public GeneralAlgorithmsTestServiceImpl(AlgorithmTestService<TwoNumbersAsArrays, int[]> sumTwoNumbersTestService) {
	this.sumTwoNumbersTestService = sumTwoNumbersTestService;
    }

    @Override
    public AlgorithmsTestsReport testSumTwoNumbersAlgorithm(int testsNumber) {
	return sumTwoNumbersTestService.testAlgorithm(testsNumber);
    }

}
