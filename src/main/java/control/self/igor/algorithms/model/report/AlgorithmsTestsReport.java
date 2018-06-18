package control.self.igor.algorithms.model.report;

import java.util.List;

import control.self.igor.algorithms.model.report.AlgorithmTestReport;

public class AlgorithmsTestsReport {

    private String generalReport;
    private List<AlgorithmTestReport> testsReports;

    public AlgorithmsTestsReport(String generalReport, List<AlgorithmTestReport> testsReports) {
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
