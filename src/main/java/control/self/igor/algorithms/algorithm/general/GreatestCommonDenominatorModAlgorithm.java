package control.self.igor.algorithms.algorithm.general;

import control.self.igor.algorithms.algorithm.Algorithm;
import control.self.igor.algorithms.model.problem.TwoNumbers;

public class GreatestCommonDenominatorModAlgorithm extends Algorithm<TwoNumbers<Integer>, Integer> {

    public GreatestCommonDenominatorModAlgorithm(TwoNumbers<Integer> problem) {
	super(problem);
    }

    @Override
    public Integer solve() {
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
