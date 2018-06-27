package control.self.igor.algorithms.service.problem.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

@Service
public class SortingProblemService implements ProblemService<List<Integer>> {

    private final static int MIN_NUMBER = -1000;
    private final static int MAX_NUMBER = 1000;

    @Override
    public List<Integer> createProblem(int problemSize) {
	return getRandomIntegers(problemSize);
    }

    @Override
    public List<List<Integer>> createProblems(int problemsNumber, int problemSize) {
	List<List<Integer>> problems = new ArrayList<>();
	for (int i = 0; i < problemsNumber; i++) {
	    problems.add(createProblem(problemSize));
	}
	return problems;
    }

    private List<Integer> getRandomIntegers(int randomIntegersNumber) {
	List<Integer> randomIntegers = new ArrayList<>();
	for (int i = 0; i < randomIntegersNumber; i++) {
	    randomIntegers.add(NumberGeneratorUtil.generateNumber(MIN_NUMBER, MAX_NUMBER));
	}
	return randomIntegers;
    }

}
