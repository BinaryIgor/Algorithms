package control.self.igor.algorithms.service.test.sorting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AbstractAlgorithmTestService;

@Service("InsertionSortAlgorithmTestService")
public class InsertionSortAlgorithmTestService extends AbstractAlgorithmTestService<List<Integer>, List<Integer>> {

    @Autowired
    public InsertionSortAlgorithmTestService(ProblemService<List<Integer>> problemService,
	    @Qualifier("InsertionSortAlgorithmService") AlgorithmService<List<Integer>, List<Integer>> algorithmService,
	    AlgorithmReportService<List<Integer>, List<Integer>> algorithmReportService) {
	super(problemService, algorithmService, algorithmReportService);
    }

}
