package control.self.igor.algorithms.model.algorithm;

import java.util.List;

import control.self.igor.algorithms.model.DurationWithUnit;

public class SolvedAlgorithms<Problem, Solution> {

    private DurationWithUnit findingAllSolutionsDuration;
    private List<SolvedAlgorithm<Problem, Solution>> solvedAlgorithms;

    public SolvedAlgorithms(DurationWithUnit allTestsDuration,
	    List<SolvedAlgorithm<Problem, Solution>> solvedAlgorithms) {
	this.findingAllSolutionsDuration = allTestsDuration;
	this.solvedAlgorithms = solvedAlgorithms;
    }

    public DurationWithUnit getFindingAllSolutionsDuration() {
	return findingAllSolutionsDuration;
    }

    public List<SolvedAlgorithm<Problem, Solution>> getSolvedAlgorithms() {
	return solvedAlgorithms;
    }

}
