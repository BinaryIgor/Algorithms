package control.self.igor.algorithms.service.problem.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

@Service
public class SortingProblemService implements ProblemService<int[]> {

    private final static int MIN_NUMBER = -1000;
    private final static int MAX_NUMBER = 1000;

    @Override
    public int[] createProblem(int problemSize) {
	return getRandomIntegers(problemSize);
    }

    @Override
    public List<int[]> createProblems(int problemsNumber, int problemSize) {
	List<int[]> problems = new ArrayList<>();
	for (int i = 0; i < problemsNumber; i++) {
	    problems.add(createProblem(problemSize));
	}
	return problems;
    }

    private int[] getRandomIntegers(int randomIntegersNumber) {
	int[] randomIntegers = new int[randomIntegersNumber];
	for (int i = 0; i < randomIntegersNumber; i++) {
	    randomIntegers[i] = NumberGeneratorUtil.generateNumber(MIN_NUMBER, MAX_NUMBER);
	}
	return randomIntegers;
    }

}
