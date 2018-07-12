package control.self.igor.algorithms.service.test.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service("BubbleSortAlgorithmTestService")
public class BubbleSortAlgorithmTestService extends AbstractAlgorithmTestService<int[], int[]> {

    @Autowired
    public BubbleSortAlgorithmTestService(ProblemService<int[]> problemService,
	    @Qualifier("BubbleSortAlgorithmService") AlgorithmService<int[], int[]> algorithmService,
	    AlgorithmReportService<int[], int[]> algorithmReportService) {
	super(problemService, algorithmService, algorithmReportService);
    }

}
