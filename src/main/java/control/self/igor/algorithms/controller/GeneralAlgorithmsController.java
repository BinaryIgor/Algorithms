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
	    @RequestParam(name = "maxNumberLength", required = false) Integer maxNumberLength) {
	if (testsNumber < 1) {
	    throw BadRequestException.createNonPositiveNumberException();
	}
	if (maxNumberLength == null || maxNumberLength < MIN_NUMBER_LENGTH) {
	    maxNumberLength = MIN_NUMBER_LENGTH;
	}
	return service.testSumTwoNumbersAlgorithm(testsNumber, maxNumberLength);
    }

    @GetMapping("/greatest-common-divisor")
    public AlgorithmsTestsReport greatestCommonDivsor(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maxNumberValue", required = false) Integer maxNumberValue) {
	if (testsNumber < 1) {
	    throw BadRequestException.createNonPositiveNumberException();
	}
	return service.testGreatestCommonDivisorAlgorithm(testsNumber, maxNumberValue);
    }

    @GetMapping("/lowest-common-multiple")
    public AlgorithmsTestsReport LowestCommonMultiple(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maxNumberValue", required = false) Integer maxNumberValue) {
	if (testsNumber < 1) {
	    throw BadRequestException.createNonPositiveNumberException();
	}
	return service.testLowestCommonMultipleAlgorithm(testsNumber, maxNumberValue);
    }
}
