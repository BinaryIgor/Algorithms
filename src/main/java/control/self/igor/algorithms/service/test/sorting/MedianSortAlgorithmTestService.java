package control.self.igor.algorithms.service.test.sorting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service("MedianSortAlgorithmTestService")
public class MedianSortAlgorithmTestService extends AbstractAlgorithmTestService<int[], int[]> {

    public MedianSortAlgorithmTestService(ProblemService<int[]> problemService,
	    @Qualifier("MedianSortAlgorithmService") AlgorithmService<int[], int[]> algorithmService,
	    AlgorithmReportService<int[], int[]> algoritmReportService) {
	super(problemService, algorithmService, algoritmReportService);
    }

}
