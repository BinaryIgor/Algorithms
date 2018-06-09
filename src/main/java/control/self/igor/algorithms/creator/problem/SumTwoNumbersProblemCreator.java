package control.self.igor.algorithms.creator.problem;

import java.util.ArrayList;
import java.util.List;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

public class SumTwoNumbersProblemCreator implements ProblemCreator<TwoNumbersAsArrays> {

    private final static int MAX_NUMBER_LENGTH = 10;

    @Override
    public TwoNumbersAsArrays create() {
	return getRandomTwoNumbers();
    }

    @Override
    public List<TwoNumbersAsArrays> create(int problemsNumber) {
	List<TwoNumbersAsArrays> problems = new ArrayList<>();
	for (int i = 0; i < problemsNumber; i++)
	    problems.add(getRandomTwoNumbers());
	return problems;
    }

    private TwoNumbersAsArrays getRandomTwoNumbers() {
	int[] first = NumberGeneratorUtil.generateNumber(MAX_NUMBER_LENGTH);
	int[] second = NumberGeneratorUtil.generateNumber(MAX_NUMBER_LENGTH);
	return new TwoNumbersAsArrays(first, second);
    }

}
