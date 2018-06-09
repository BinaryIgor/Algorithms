package control.self.igor.algorithms.algorithm;

public abstract class Algorithm<Problem, Solution> {

    protected Problem problem;

    public Algorithm(Problem problem) {
	this.problem = problem;
    }

    public abstract Solution solve();

}
