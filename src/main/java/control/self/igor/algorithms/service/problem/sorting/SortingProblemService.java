package control.self.igor.algorithms.service.problem.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.problem.ProblemService;
import control.self.igor.algorithms.util.NumberGeneratorUtil;

@Service
public class SortingProblemService implements ProblemService<int[]> {

    private static final int MIN_NUMBER = -1000;
    private static final int MAX_NUMBER = 1000;

    @Override
    public int[] createProblem(int problemSize) {
	int[] randomIntegers = new int[problemSize];
	for (int i = 0; i < problemSize; i++) {
	    randomIntegers[i] = NumberGeneratorUtil.generateNumber(MIN_NUMBER, MAX_NUMBER);
	}
	return randomIntegers;
    }

    @Override
    public List<int[]> createProblems(int problemsNumber, int problemSize) {
	List<int[]> problems = new ArrayList<>();
	for (int i = 0; i < problemsNumber; i++) {
	    problems.add(createProblem(problemSize));
	}
	return problems;
    }

}
