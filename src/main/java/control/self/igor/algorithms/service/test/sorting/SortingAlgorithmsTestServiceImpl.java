package control.self.igor.algorithms.service.test.sorting;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;
import control.self.igor.algorithms.service.test.AlgorithmTestService;

public class SortingAlgorithmsTestServiceImpl implements SortingAlgorithmsTestService {

    private AlgorithmTestService<List<Integer>, List<Integer>> bubbleSortTestService;

    public SortingAlgorithmsTestServiceImpl(ProblemService<List<Integer>> problemService,
	    @Qualifier("BubbleSortAlgorithmService") AlgorithmService<List<Integer>, List<Integer>> bubbleSortAlgorithmService,
	    AlgorithmReportService<List<Integer>, List<Integer>> algorithmReportService) {
	this.bubbleSortTestService = new AlgorithmTestService<>(problemService, bubbleSortAlgorithmService,
		algorithmReportService);
    }

    @Override
    public AlgorithmsTestsReport testBubbleSort(int testsNumber) {
	return bubbleSortTestService.testAlgorithm(testsNumber);
    }

}
