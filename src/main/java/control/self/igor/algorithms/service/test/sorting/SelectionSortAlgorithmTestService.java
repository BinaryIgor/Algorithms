package control.self.igor.algorithms.service.test.sorting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service("SelectionSortAlgorithmTestService")
public class SelectionSortAlgorithmTestService extends AbstractAlgorithmTestService<int[], int[]> {

    public SelectionSortAlgorithmTestService(ProblemService<int[]> problemService,
	    @Qualifier("SelectionSortAlgorithmService") AlgorithmService<int[], int[]> algorithmService,
	    AlgorithmReportService<int[], int[]> algoritmReportService) {
	super(problemService, algorithmService, algoritmReportService);
    }

}
