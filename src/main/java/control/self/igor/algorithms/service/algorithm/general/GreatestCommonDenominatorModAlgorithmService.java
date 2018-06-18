package control.self.igor.algorithms.service.algorithm.general;

import control.self.igor.algorithms.model.problem.TwoNumbers;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;

public class GreatestCommonDenominatorModAlgorithmService implements AlgorithmService<TwoNumbers<Integer>, Integer> {

    @Override
    public Integer solve(TwoNumbers<Integer> problem) {
	int first = problem.getFirst();
	int second = problem.getSecond();
	while (second != 0) {
	    int tmp = second;
	    second = first % second;
	    first = tmp;
	}
	return first;
    }

}
