package control.self.igor.algorithms.model.test;

import control.self.igor.algorithms.model.DurationWithUnit;

public class AlgorithmTest<Problem, Solution> {

    private Problem problem;
    private Solution solution;
    private DurationWithUnit findingSolutionDuration;

    public AlgorithmTest(Problem problem, Solution solution, DurationWithUnit findingSolutionDuration) {
	this.problem = problem;
	this.solution = solution;
	this.findingSolutionDuration = findingSolutionDuration;
    }

    public Problem getProblem() {
	return problem;
    }

    public Solution getSolution() {
	return solution;
    }

    public DurationWithUnit getFindingSolutionDuration() {
	return findingSolutionDuration;
    }

}
