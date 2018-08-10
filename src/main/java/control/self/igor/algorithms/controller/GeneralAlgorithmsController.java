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
    private static final int DEFAULT_MAX_NUMBER_VALUE = 100;
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
    public AlgorithmsTestsReport greatestCommonDivisor(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maxNumberValue", required = false) Integer maxNumberValue) {
	return common(testsNumber, maxNumberValue, CommonType.GREATEST_COMMON_DIVISOR);
    }

    @GetMapping("/lowest-common-multiple")
    public AlgorithmsTestsReport lowestCommonMultiple(@RequestParam("testsNumber") int testsNumber,
	    @RequestParam(name = "maxNumberValue", required = false) Integer maxNumberValue) {
	return common(testsNumber, maxNumberValue, CommonType.LOWEST_COMMON_MULTIPLE);
    }

    private AlgorithmsTestsReport common(int testsNumber, Integer maxNumberValue, CommonType commonType) {
	if (maxNumberValue == null) {
	    maxNumberValue = DEFAULT_MAX_NUMBER_VALUE;
	}
	if (testsNumber < 1 || maxNumberValue < 1) {
	    throw BadRequestException.createNonPositiveNumberException();
	}
	if (commonType.equals(CommonType.GREATEST_COMMON_DIVISOR)) {
	    return service.testGreatestCommonDivisorAlgorithm(testsNumber, maxNumberValue);
	}
	return service.testLowestCommonMultipleAlgorithm(testsNumber, maxNumberValue);
    }

    private enum CommonType {
	GREATEST_COMMON_DIVISOR, LOWEST_COMMON_MULTIPLE;
    }
}
