package control.self.igor.algorithms.service.report.general;

import org.springframework.stereotype.Service;

@Service("GreatestCommonDivisorAlgorithmReportService")
public class GreatestCommonDivisorAlgorithmReportService extends CommonNumberReportService {

    public GreatestCommonDivisorAlgorithmReportService() {
	super(Mode.GREATEST_COMMON_DIVISOR);
    }

}
