package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.List;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;

@Service("BubbleSortAlgorithmService")
public class BubbleSortAlgorithmService implements AlgorithmService<List<Integer>, List<Integer>> {

    @Override
    public List<Integer> solve(List<Integer> problem) {
	int problemSize = problem.size();
	boolean swapped;
	do {
	    swapped = false;
	    for (int i = 1; i < problemSize; i++) {
		Integer first = problem.get(i - 1);
		Integer second = problem.get(i);
		if (first > second) {
		    problem.set(i - 1, second);
		    problem.set(i, first);
		    swapped = true;
		}
	    }
	    --problemSize;

	} while (swapped);
	return problem;
    }

    @Override
    public String getAlgorithmName() {
	return "Bubble Sort";
    }

}
