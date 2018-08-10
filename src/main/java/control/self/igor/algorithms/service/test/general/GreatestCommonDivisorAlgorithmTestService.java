package control.self.igor.algorithms.service.test.general;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service("GreatestCommonDivisorAlgorithmTestService")
public class GreatestCommonDivisorAlgorithmTestService
	extends AbstractAlgorithmTestService<TwoNumbersAsIntegers, Integer> {

    public GreatestCommonDivisorAlgorithmTestService(ProblemService<TwoNumbersAsIntegers> problemService,
	    @Qualifier("GreatestCommonDivisorAlgorithmService") AlgorithmService<TwoNumbersAsIntegers, Integer> algorithmService,
	    @Qualifier("GreatestCommonDivisorAlgorithmReportService") AlgorithmReportService<TwoNumbersAsIntegers, Integer> algoritmReportService) {
	super(problemService, algorithmService, algoritmReportService);
    }

}
