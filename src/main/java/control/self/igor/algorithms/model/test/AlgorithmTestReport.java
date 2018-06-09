package control.self.igor.algorithms.model.test;

public class AlgorithmTestReport {

    private String problem;
    private String solution;
    private String duration;

    public AlgorithmTestReport(String problem, String solution, String duration) {
	this.problem = problem;
	this.solution = solution;
	this.duration = duration;
    }

    public String getProblem() {
	return problem;
    }

    public String getSolution() {
	return solution;
    }

    public String getDuration() {
	return duration;
    }

}
