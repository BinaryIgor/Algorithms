package control.self.igor.algorithms.service.test.general;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service("LowestCommonMultipleAlgorithmTestService")
public class LowestCommonMultipleAlgorithmTestService
	extends AbstractAlgorithmTestService<TwoNumbersAsIntegers, Integer> {

    public LowestCommonMultipleAlgorithmTestService(ProblemService<TwoNumbersAsIntegers> problemService,
	    @Qualifier("LowestCommonMultipleAlgorithmService") AlgorithmService<TwoNumbersAsIntegers, Integer> algorithmService,
	    @Qualifier("LowestCommonMultipleAlgorithmReportService") AlgorithmReportService<TwoNumbersAsIntegers, Integer> algoritmReportService) {
	super(problemService, algorithmService, algoritmReportService);
    }

}
