package control.self.igor.algorithms.service.problem.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

@Service
public class SumTwoNumbersProblemService implements ProblemService<TwoNumbersAsArrays> {

    private final static int MAX_NUMBER_LENGTH = 10;

    @Override
    public TwoNumbersAsArrays createProblem() {
	return getRandomTwoNumbers();
    }

    @Override
    public List<TwoNumbersAsArrays> createProblems(int problemsNumber) {
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
