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
    private AlgorithmTestService<List<Integer>, List<Integer>> selectionSortAlgorithmTestService;
    private AlgorithmTestService<List<Integer>, List<Integer>> insertionSortAlgorithmTestService;
    private AlgorithmTestService<List<Integer>, List<Integer>> shellSortAlgorithmTestService;

    @Autowired
    public SortingAlgorithmsTestServiceImpl(
	    @Qualifier("BubbleSortAlgorithmTestService") AlgorithmTestService<List<Integer>, List<Integer>> bubbleSortAlgorithmTestService,
	    @Qualifier("SelectionSortAlgorithmTestService") AlgorithmTestService<List<Integer>, List<Integer>> selectionSortAlgorithmTestService,
	    @Qualifier("InsertionSortAlgorithmTestService") AlgorithmTestService<List<Integer>, List<Integer>> insertionSortAlgorithmTestService,
	    @Qualifier("ShellSortAlgorithmTestService") AlgorithmTestService<List<Integer>, List<Integer>> shellSortAlgorithmTestService) {
	this.bubbleSortAlgorithmTestService = bubbleSortAlgorithmTestService;
	this.selectionSortAlgorithmTestService = selectionSortAlgorithmTestService;
	this.insertionSortAlgorithmTestService = insertionSortAlgorithmTestService;
	this.shellSortAlgorithmTestService = shellSortAlgorithmTestService;
    }

    @Override
    public AlgorithmsTestsReport testBubbleSort(int testsNumber, int maximalToSortListSize) {
	return bubbleSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);

    }

    @Override
    public AlgorithmsTestsReport testSelectionSort(int testsNumber, int maximalToSortListSize) {
	return selectionSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);
    }

    @Override
    public AlgorithmsTestsReport testInsertionSort(int testsNumber, int maximalToSortListSize) {
	return insertionSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);
    }

    @Override
    public AlgorithmsTestsReport testShellSort(int testsNumber, int maximalToSortListSize) {
	return shellSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);
    }

}
