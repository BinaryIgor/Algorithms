package control.self.igor.algorithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import control.self.igor.algorithms.exception.BadRequestException;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.general.GeneralAlgorithmsTestService;

@RestController
@RequestMapping("/general")
public class GeneralAlgorithmsController {

    private static final int MIN_NUMBER_LENGTH = 1;
    private GeneralAlgorithmsTestService service;

    @Autowired
    public GeneralAlgorithmsController(GeneralAlgorithmsTestService service) {
	this.service = service;
    }

    @GetMapping("/sum")
    public AlgorithmsTestsReport sum(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maximalNumberLength", required = true) Integer maximalNumberLength) {
	if (testsNumber < 1) {
	    throw BadRequestException.createNotPositiveNumberException();
	}
	if (maximalNumberLength == null || maximalNumberLength < MIN_NUMBER_LENGTH) {
	    maximalNumberLength = MIN_NUMBER_LENGTH;
	}
	return service.testSumTwoNumbersAlgorithm(testsNumber, maximalNumberLength);
    }
}
