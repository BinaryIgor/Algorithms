package control.self.igor.algorithms.model.algorithm;

import control.self.igor.algorithms.model.DurationWithUnit;

public class SolvedAlgorithm<Problem, Solution> {

    private String name;
    private Problem problem;
    private Solution solution;
    private DurationWithUnit findingSolutionDuration;

    public SolvedAlgorithm(String name, Problem problem, Solution solution, DurationWithUnit findingSolutionDuration) {
	this.name = name;
	this.problem = problem;
	this.solution = solution;
	this.findingSolutionDuration = findingSolutionDuration;
    }

    public String getName() {
	return name;
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
