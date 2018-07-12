package control.self.igor.algorithms.service.test.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.AlgorithmTestService;

@Service
public class SortingAlgorithmsTestServiceImpl implements SortingAlgorithmsTestService {

    private AlgorithmTestService<int[], int[]> bubbleSortAlgorithmTestService;
    private AlgorithmTestService<int[], int[]> selectionSortAlgorithmTestService;
    private AlgorithmTestService<int[], int[]> insertionSortAlgorithmTestService;
    private AlgorithmTestService<int[], int[]> shellSortAlgorithmTestService;
    private AlgorithmTestService<int[], int[]> mergeSortAlgorithmTestService;
    private AlgorithmTestService<int[], int[]> quickSortAlgorithmTestService;

    @Autowired
    public SortingAlgorithmsTestServiceImpl(
	    @Qualifier("BubbleSortAlgorithmTestService") AlgorithmTestService<int[], int[]> bubbleSortAlgorithmTestService,
	    @Qualifier("SelectionSortAlgorithmTestService") AlgorithmTestService<int[], int[]> selectionSortAlgorithmTestService,
	    @Qualifier("InsertionSortAlgorithmTestService") AlgorithmTestService<int[], int[]> insertionSortAlgorithmTestService,
	    @Qualifier("ShellSortAlgorithmTestService") AlgorithmTestService<int[], int[]> shellSortAlgorithmTestService,
	    @Qualifier("MergeSortAlgorithmTestService") AlgorithmTestService<int[], int[]> mergeSortAlgorithmTestService,
	    @Qualifier("QuickSortAlgorithmTestService") AlgorithmTestService<int[], int[]> quickSortAlgorithmTestService) {
	this.bubbleSortAlgorithmTestService = bubbleSortAlgorithmTestService;
	this.selectionSortAlgorithmTestService = selectionSortAlgorithmTestService;
	this.insertionSortAlgorithmTestService = insertionSortAlgorithmTestService;
	this.shellSortAlgorithmTestService = shellSortAlgorithmTestService;
	this.mergeSortAlgorithmTestService = mergeSortAlgorithmTestService;
	this.quickSortAlgorithmTestService = quickSortAlgorithmTestService;
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

    @Override
    public AlgorithmsTestsReport testMergeSort(int testsNumber, int maximalToSortListSize) {
	return mergeSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);
    }

    @Override
    public AlgorithmsTestsReport testQuickSort(int testsNumber, int maximalToSortListSize) {
	return quickSortAlgorithmTestService.testAlgorithm(testsNumber, maximalToSortListSize);
    }

}
