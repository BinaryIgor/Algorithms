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
    private AlgorithmTestService<int[], int[]> medianSortAlgorithmTestService;

    @Autowired
    public SortingAlgorithmsTestServiceImpl(
	    @Qualifier("BubbleSortAlgorithmTestService") AlgorithmTestService<int[], int[]> bubbleSortAlgorithmTestService,
	    @Qualifier("SelectionSortAlgorithmTestService") AlgorithmTestService<int[], int[]> selectionSortAlgorithmTestService,
	    @Qualifier("InsertionSortAlgorithmTestService") AlgorithmTestService<int[], int[]> insertionSortAlgorithmTestService,
	    @Qualifier("ShellSortAlgorithmTestService") AlgorithmTestService<int[], int[]> shellSortAlgorithmTestService,
	    @Qualifier("MergeSortAlgorithmTestService") AlgorithmTestService<int[], int[]> mergeSortAlgorithmTestService,
	    @Qualifier("QuickSortAlgorithmTestService") AlgorithmTestService<int[], int[]> quickSortAlgorithmTestService,
	    @Qualifier("MedianSortAlgorithmTestService") AlgorithmTestService<int[], int[]> medianSortAlgorithmTestService) {
	this.bubbleSortAlgorithmTestService = bubbleSortAlgorithmTestService;
	this.selectionSortAlgorithmTestService = selectionSortAlgorithmTestService;
	this.insertionSortAlgorithmTestService = insertionSortAlgorithmTestService;
	this.shellSortAlgorithmTestService = shellSortAlgorithmTestService;
	this.mergeSortAlgorithmTestService = mergeSortAlgorithmTestService;
	this.quickSortAlgorithmTestService = quickSortAlgorithmTestService;
	this.medianSortAlgorithmTestService = medianSortAlgorithmTestService;
    }

    @Override
    public AlgorithmsTestsReport testBubbleSort(int testsNumber, int toSortDataSize) {
	return bubbleSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);

    }

    @Override
    public AlgorithmsTestsReport testSelectionSort(int testsNumber, int toSortDataSize) {
	return selectionSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);
    }

    @Override
    public AlgorithmsTestsReport testInsertionSort(int testsNumber, int toSortDataSize) {
	return insertionSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);
    }

    @Override
    public AlgorithmsTestsReport testShellSort(int testsNumber, int toSortDataSize) {
	return shellSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);
    }

    @Override
    public AlgorithmsTestsReport testMergeSort(int testsNumber, int toSortDataSize) {
	return mergeSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);
    }

    @Override
    public AlgorithmsTestsReport testQuickSort(int testsNumber, int toSortDataSize) {
	return quickSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);
    }

    @Override
    public AlgorithmsTestsReport testMedianSort(int testsNumber, int toSortDataSize) {
	return medianSortAlgorithmTestService.testAlgorithm(testsNumber, toSortDataSize);
    }

}
