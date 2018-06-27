package control.self.igor.algorithms.service.test.sorting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.AlgorithmTestService;

@Service
public class SortingAlgorithmsTestServiceImpl implements SortingAlgorithmsTestService {

    private AlgorithmTestService<List<Integer>, List<Integer>> bubbleSortAlgorithmTestService;

    @Autowired
    public SortingAlgorithmsTestServiceImpl(
	    @Qualifier("BubbleSortAlgorithmTestService") AlgorithmTestService<List<Integer>, List<Integer>> bubbleSortAlgorithmTestService) {
	this.bubbleSortAlgorithmTestService = bubbleSortAlgorithmTestService;
    }

    @Override
    public AlgorithmsTestsReport testBubbleSort(int testsNumber, int maximalToSortListSize) {
	return bubbleSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);

    }

}
