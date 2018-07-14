package control.self.igor.algorithms.service.test.sorting;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;

public interface SortingAlgorithmsTestService {

    AlgorithmsTestsReport testBubbleSort(int testsNumber, int toSortDataSize);

    AlgorithmsTestsReport testSelectionSort(int testsNumber, int toSortDataSize);

    AlgorithmsTestsReport testInsertionSort(int testsNumber, int toSortDataSize);

    AlgorithmsTestsReport testShellSort(int testsNumber, int toSortDataSize);

    AlgorithmsTestsReport testMergeSort(int testsNumber, int toSortDataSize);

    AlgorithmsTestsReport testQuickSort(int testsNumber, int toSortDataSize);
}
