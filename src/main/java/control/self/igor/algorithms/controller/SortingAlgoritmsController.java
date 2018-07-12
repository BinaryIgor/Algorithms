package control.self.igor.algorithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import control.self.igor.algorithms.exception.BadRequestException;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.sorting.SortingAlgorithmsTestService;

@RestController
@RequestMapping("/sorting")
public class SortingAlgoritmsController {

    private static final int DEFAULT_MAXIMAL_TO_SORT_LIST_SIZE = 1000;
    private SortingAlgorithmsTestService testService;

    @Autowired
    public SortingAlgoritmsController(SortingAlgorithmsTestService testService) {
	this.testService = testService;
    }

    @GetMapping("/bubble-sort")
    public AlgorithmsTestsReport bubbleSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalToSortListSize", required = false) Integer maximalToSortListSize) {
	return sort(SortingAlgorithm.BUBBLE, testsNumber, maximalToSortListSize);
    }

    @GetMapping("/selection-sort")
    public AlgorithmsTestsReport selectionSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalToSortListSize", required = false) Integer maximalToSortListSize) {
	return sort(SortingAlgorithm.SELECTION, testsNumber, maximalToSortListSize);
    }

    @GetMapping("/insertion-sort")
    public AlgorithmsTestsReport insertionSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalToSortListSize", required = false) Integer maximalToSortListSize) {
	return sort(SortingAlgorithm.INSERTION, testsNumber, maximalToSortListSize);
    }

    @GetMapping("/shell-sort")
    public AlgorithmsTestsReport shellSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalToSortListSize", required = false) Integer maximalToSortListSize) {
	return sort(SortingAlgorithm.SHELL, testsNumber, maximalToSortListSize);
    }

    @GetMapping("/merge-sort")
    public AlgorithmsTestsReport mergeSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalToSortListSize", required = false) Integer maximalToSortListSize) {
	return sort(SortingAlgorithm.MERGE, testsNumber, maximalToSortListSize);
    }

    @GetMapping("/quick-sort")
    public AlgorithmsTestsReport quickSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalToSortListSize", required = false) Integer maximalToSortListSize) {
	return sort(SortingAlgorithm.QUICK, testsNumber, maximalToSortListSize);
    }

    private AlgorithmsTestsReport sort(SortingAlgorithm sortingAlgorithm, int testsNumber,
	    Integer maximalToSortListSize) {
	if (testsNumber < 1) {
	    throw BadRequestException.createNotPositiveNumberException();
	}
	if (maximalToSortListSize == null || maximalToSortListSize < 1) {
	    maximalToSortListSize = DEFAULT_MAXIMAL_TO_SORT_LIST_SIZE;
	}
	if (sortingAlgorithm == SortingAlgorithm.BUBBLE) {
	    return testService.testBubbleSort(testsNumber, maximalToSortListSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.SELECTION) {
	    return testService.testSelectionSort(testsNumber, maximalToSortListSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.INSERTION) {
	    return testService.testInsertionSort(testsNumber, maximalToSortListSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.SHELL) {
	    return testService.testShellSort(testsNumber, maximalToSortListSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.MERGE) {
	    return testService.testMergeSort(testsNumber, maximalToSortListSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.QUICK) {
	    return testService.testQuickSort(testsNumber, maximalToSortListSize);
	}
	return null;
    }

    private enum SortingAlgorithm {
	BUBBLE, SELECTION, INSERTION, SHELL, MERGE, QUICK;
    }

}
