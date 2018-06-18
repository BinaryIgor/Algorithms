package control.self.igor.algorithms.service.test.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.algorithm.general.SumTwoNumbersAlgorithmService;
import control.self.igor.algorithms.service.problem.general.SumTwoNumbersProblemService;
import control.self.igor.algorithms.service.report.general.SumTwoNumbersReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmsTestService;

@Service
public class GeneralAlgorithmsTestServiceImpl extends AbstractAlgorithmsTestService<TwoNumbersAsArrays, int[]>
	implements GeneralAlgorithmsTestService {

    @Autowired
    public GeneralAlgorithmsTestServiceImpl(SumTwoNumbersProblemService sumTwoNumbersProblemService,
	    SumTwoNumbersAlgorithmService sumTwoNumbersAlgorithmService,
	    SumTwoNumbersReportService sumTwoNumbersReportService) {
	super(sumTwoNumbersProblemService, sumTwoNumbersAlgorithmService, sumTwoNumbersReportService);
    }

    @Override
    public AlgorithmsTestsReport testSumTwoNumbersAlgorithm(int testsNumber) {
	return testAlgorithm(testsNumber);
    }

}
