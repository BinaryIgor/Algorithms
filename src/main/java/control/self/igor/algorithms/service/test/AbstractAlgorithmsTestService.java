package control.self.igor.algorithms.service.test;

import java.util.ArrayList;
import java.util.List;

import control.self.igor.algorithms.model.DurationWithUnit;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithm;
import control.self.igor.algorithms.model.algorithm.SolvedAlgorithms;
import control.self.igor.algorithms.model.report.AlgorithmsTestsReport;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.service.report.AlgorithmReportService;

public abstract class AbstractAlgorithmsTestService<Problem, Solution> {

    private ProblemService<Problem> problemService;
    private AlgorithmService<Problem, Solution> algorithmService;
    private AlgorithmReportService<Problem, Solution> algoritmReportService;

    public AbstractAlgorithmsTestService(ProblemService<Problem> problemService,
	    AlgorithmService<Problem, Solution> algorithmService,
	    AlgorithmReportService<Problem, Solution> algoritmReportService) {
	this.problemService = problemService;
	this.algorithmService = algorithmService;
	this.algoritmReportService = algoritmReportService;
    }

    public AlgorithmsTestsReport testAlgorithm(int testsNumber) {
	List<Problem> problems = problemService.createProblems(testsNumber);
	long startTime = System.nanoTime();
	List<SolvedAlgorithm<Problem, Solution>> solvedAlgorithmsCollection = solveAlgorithms(problems);
	long endTime = System.nanoTime();
	DurationWithUnit findingAllSolutionsDuration = DurationWithUnit.createMillisFromNanos(endTime - startTime);
	SolvedAlgorithms<Problem, Solution> solvedAlgorithms = new SolvedAlgorithms<>(findingAllSolutionsDuration,
		solvedAlgorithmsCollection);
	return algoritmReportService.createReport(solvedAlgorithms);
    }

    private List<SolvedAlgorithm<Problem, Solution>> solveAlgorithms(List<Problem> problems) {
	List<SolvedAlgorithm<Problem, Solution>> solvedAlgorithms = new ArrayList<>();
	for (Problem problem : problems) {
	    solvedAlgorithms.add(solveAlgorithm(problem));
	}
	return solvedAlgorithms;
    }

    private SolvedAlgorithm<Problem, Solution> solveAlgorithm(Problem problem) {
	long startTime = System.nanoTime();
	Solution solution = algorithmService.solve(problem);
	long endTime = System.nanoTime();
	DurationWithUnit findingSolutionDuration = DurationWithUnit.createNanos(endTime - startTime);
	return new SolvedAlgorithm<Problem, Solution>(problem, solution, findingSolutionDuration);
    }
}
