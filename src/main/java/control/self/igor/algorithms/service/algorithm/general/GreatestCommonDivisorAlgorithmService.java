package control.self.igor.algorithms.service.algorithm.general;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;

@Service("GreatestCommonDivisorAlgorithmService")
public class GreatestCommonDivisorAlgorithmService implements AlgorithmService<TwoNumbersAsIntegers, Integer> {

    @Override
    public Integer solve(TwoNumbersAsIntegers problem) {
	int first = problem.getFirst();
	int second = problem.getSecond();
	while (second != 0) {
	    int tmp = second;
	    second = first % second;
	    first = tmp;
	}
	return first;
    }

    @Override
    public String getAlgorithmName() {
	return "Greatest Common Divisor Algorithm";
    }

}
