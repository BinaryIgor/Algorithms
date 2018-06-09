package control.self.igor.algorithms.model.test;

import java.util.List;

public class AlgorithmsTestsReports {

    private String generalReport;
    private List<AlgorithmTestReport> testsReports;

    public AlgorithmsTestsReports(String generalReport, List<AlgorithmTestReport> testsReports) {
	this.generalReport = generalReport;
	this.testsReports = testsReports;
    }

    public String getGeneralReport() {
	return generalReport;
    }

    public List<AlgorithmTestReport> getTestsReports() {
	return testsReports;
    }

}
