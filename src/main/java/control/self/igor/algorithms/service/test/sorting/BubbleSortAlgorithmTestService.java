package control.self.igor.algorithms.service.test.sorting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;
import control.self.igor.algorithms.service.test.AlgorithmTestService;

@Service("BubbleSortAlgorithmTestService")
public class BubbleSortAlgorithmTestService extends AbstractAlgorithmTestService<List<Integer>, List<Integer>>
	implements AlgorithmTestService<List<Integer>, List<Integer>> {

    @Autowired
    public BubbleSortAlgorithmTestService(ProblemService<List<Integer>> problemService,
	    @Qualifier("BubbleSortAlgorithmService") AlgorithmService<List<Integer>, List<Integer>> algorithmService,
	    AlgorithmReportService<List<Integer>, List<Integer>> algoritmReportService) {
	super(problemService, algorithmService, algoritmReportService);
    }

}
