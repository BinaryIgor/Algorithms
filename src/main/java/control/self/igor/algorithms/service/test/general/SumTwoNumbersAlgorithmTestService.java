package control.self.igor.algorithms.service.test.general;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service
public class SumTwoNumbersAlgorithmTestService extends AbstractAlgorithmTestService<TwoNumbersAsArrays, int[]> {

    public SumTwoNumbersAlgorithmTestService(ProblemService<TwoNumbersAsArrays> problemService,
	    AlgorithmService<TwoNumbersAsArrays, int[]> algorithmService,
	    AlgorithmReportService<TwoNumbersAsArrays, int[]> algoritmReportService) {
	super(problemService, algorithmService, algoritmReportService);
    }

}
