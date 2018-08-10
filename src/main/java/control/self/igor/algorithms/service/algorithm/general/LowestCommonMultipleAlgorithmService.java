package control.self.igor.algorithms.service.algorithm.general;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;

@Service("LowestCommonMultipleAlgorithmService")
public class LowestCommonMultipleAlgorithmService implements AlgorithmService<TwoNumbersAsIntegers, Integer> {

    private GreatestCommonDivisorAlgorithmService greatestCommonDivisorAlgorithmService;

    public LowestCommonMultipleAlgorithmService(
	    GreatestCommonDivisorAlgorithmService greatestCommonDivisorAlgorithmService) {
	this.greatestCommonDivisorAlgorithmService = greatestCommonDivisorAlgorithmService;
    }

    @Override
    public Integer solve(TwoNumbersAsIntegers problem) {
	Integer greatestCommonDivisor = greatestCommonDivisorAlgorithmService.solve(problem);
	Integer lowestCommonMultiplier = (problem.getFirst() * problem.getSecond()) / greatestCommonDivisor;
	return lowestCommonMultiplier;
    }

    @Override
    public String getAlgorithmName() {
	return "Lowest Common Multiple Algorithm";
    }

}
