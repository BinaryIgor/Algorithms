package control.self.igor.algorithms.model.report;

public class AlgorithmTestReport {

    private String algorithmName;

    private String problem;
    private String solution;
    private String duration;

    public AlgorithmTestReport(String algorithmName, String problem, String solution, String duration) {
	this.algorithmName = algorithmName;
	this.problem = problem;
	this.solution = solution;
	this.duration = duration;
    }

    public String getAlgorithmName() {
	return algorithmName;
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
