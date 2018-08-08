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

    private static final int DEFAULT_TO_SORT_DATA_SIZE = 1000;
    private SortingAlgorithmsTestService testService;

    @Autowired
    public SortingAlgoritmsController(SortingAlgorithmsTestService testService) {
	this.testService = testService;
    }

    @GetMapping("/bubble-sort")
    public AlgorithmsTestsReport bubbleSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.BUBBLE, testsNumber, toSortDataSize);
    }

    @GetMapping("/selection-sort")
    public AlgorithmsTestsReport selectionSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.SELECTION, testsNumber, toSortDataSize);
    }

    @GetMapping("/insertion-sort")
    public AlgorithmsTestsReport insertionSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.INSERTION, testsNumber, toSortDataSize);
    }

    @GetMapping("/shell-sort")
    public AlgorithmsTestsReport shellSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.SHELL, testsNumber, toSortDataSize);
    }

    @GetMapping("/merge-sort")
    public AlgorithmsTestsReport mergeSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.MERGE, testsNumber, toSortDataSize);
    }

    @GetMapping("/quick-sort")
    public AlgorithmsTestsReport quickSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.QUICK, testsNumber, toSortDataSize);
    }

    @GetMapping("/heap-sort")
    public AlgorithmsTestsReport heapSort(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "toSortDataSize", required = false) Integer toSortDataSize) {
	return sort(SortingAlgorithm.HEAP, testsNumber, toSortDataSize);
    }

    private AlgorithmsTestsReport sort(SortingAlgorithm sortingAlgorithm, int testsNumber, Integer toSortDataSize) {
	if (testsNumber < 1) {
	    throw BadRequestException.createNotPositiveNumberException();
	}
	if (toSortDataSize == null || toSortDataSize < 1) {
	    toSortDataSize = DEFAULT_TO_SORT_DATA_SIZE;
	}
	if (sortingAlgorithm == SortingAlgorithm.BUBBLE) {
	    return testService.testBubbleSort(testsNumber, toSortDataSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.SELECTION) {
	    return testService.testSelectionSort(testsNumber, toSortDataSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.INSERTION) {
	    return testService.testInsertionSort(testsNumber, toSortDataSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.SHELL) {
	    return testService.testShellSort(testsNumber, toSortDataSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.MERGE) {
	    return testService.testMergeSort(testsNumber, toSortDataSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.QUICK) {
	    return testService.testQuickSort(testsNumber, toSortDataSize);
	}
	if (sortingAlgorithm == SortingAlgorithm.HEAP) {
	    return testService.testHeapSort(testsNumber, toSortDataSize);
	}
	return null;
    }

    private enum SortingAlgorithm {
	BUBBLE, SELECTION, INSERTION, SHELL, MERGE, QUICK, HEAP
    }

}
