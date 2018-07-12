package control.self.igor.algorithms.service.test.sorting;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;

public interface SortingAlgorithmsTestService {

    AlgorithmsTestsReport testBubbleSort(int testsNumber, int maximalToSortListSize);

    AlgorithmsTestsReport testSelectionSort(int testsNumber, int maximalToSortListSize);

    AlgorithmsTestsReport testInsertionSort(int testsNumber, int maximalToSortListSize);

    AlgorithmsTestsReport testShellSort(int testsNumber, int maximalToSortListSize);

    AlgorithmsTestsReport testMergeSort(int testsNumber, int maximalToSortListSize);

    AlgorithmsTestsReport testQuickSort(int testsNumber, int maximalToSortListSize);
}
