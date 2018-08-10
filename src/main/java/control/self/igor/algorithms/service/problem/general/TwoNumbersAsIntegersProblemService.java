package control.self.igor.algorithms.service.problem.general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;
import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

@Service
public class TwoNumbersAsIntegersProblemService implements ProblemService<TwoNumbersAsIntegers> {

    @Override
    public TwoNumbersAsIntegers createProblem(int problemSize) {
	int first = NumberGeneratorUtil.generateNumber(1, problemSize);
	int second = NumberGeneratorUtil.generateNumber(1, problemSize);
	return new TwoNumbersAsIntegers(first, second);
    }

    @Override
    public List<TwoNumbersAsIntegers> createProblems(int problemsNumber, int problemSize) {
	List<TwoNumbersAsIntegers> numbers = new ArrayList<>();
	for (int i = 0; i < problemsNumber; i++) {
	    numbers.add(createProblem(problemSize));
	}
	return numbers;
    }

}
