package control.self.igor.algorithms.service.report.general;

import org.springframework.stereotype.Service;

@Service("LowestCommonMultipleAlgorithmReportService")
public class LowestCommonMultipleAlgorithmReportService extends CommonNumberReportService {

    public LowestCommonMultipleAlgorithmReportService() {
	super(Mode.LOWEST_COMMON_MULTLIPLE);
    }

}
