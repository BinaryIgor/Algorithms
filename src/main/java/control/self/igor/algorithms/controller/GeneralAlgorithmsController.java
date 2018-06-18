package control.self.igor.algorithms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.test.general.GeneralAlgorithmsTestService;

@RestController
@RequestMapping("/general")
public class GeneralAlgorithmsController {

    private final static int TESTS_NUMBER = 10_000;
    private GeneralAlgorithmsTestService service;

    public GeneralAlgorithmsController(GeneralAlgorithmsTestService service) {
	this.service = service;
    }

    @GetMapping("/sum")
    public AlgorithmsTestsReport sum() {
	return service.testSumTwoNumbersAlgorithm(TESTS_NUMBER);
    }
}
