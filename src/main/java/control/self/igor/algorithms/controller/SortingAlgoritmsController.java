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

    private SortingAlgorithmsTestService testService;

    @Autowired
    public SortingAlgoritmsController(SortingAlgorithmsTestService testService) {
	this.testService = testService;
    }

    @GetMapping("/bubble-sort")
    public AlgorithmsTestsReport bubbleSort(@RequestParam("testsNumber") int testsNumber) {
	if (testsNumber < 0) {
	    throw BadRequestException.createNotPositiveNumberException();
	}
	return testService.testBubbleSort(testsNumber);
    }

}
