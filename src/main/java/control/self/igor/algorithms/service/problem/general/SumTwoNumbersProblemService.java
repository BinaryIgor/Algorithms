package control.self.igor.algorithms.service.problem.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

@Service
public class SumTwoNumbersProblemService implements ProblemService<TwoNumbersAsArrays> {

    @Override
    public TwoNumbersAsArrays createProblem(int problemSize) {
	return getRandomTwoNumbers(problemSize);
    }

    @Override
    public List<TwoNumbersAsArrays> createProblems(int problemsNumber, int problemSize) {
	List<TwoNumbersAsArrays> problems = new ArrayList<>();
	for (int i = 0; i < problemsNumber; i++)
	    problems.add(getRandomTwoNumbers(problemSize));
	return problems;
    }

    private TwoNumbersAsArrays getRandomTwoNumbers(int problemSize) {
	int[] first = NumberGeneratorUtil.generateNumber(problemSize);
	int[] second = NumberGeneratorUtil.generateNumber(problemSize);
	return new TwoNumbersAsArrays(first, second);
    }

}
