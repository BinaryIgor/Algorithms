package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("BubbleSortAlgorithmService")
public class BubbleSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	int problemSize = toSortNumbers.length;
	boolean swapped;
	do {
	    swapped = false;
	    for (int i = 1; i < problemSize; i++) {
		if (toSortNumbers[i - 1] > toSortNumbers[i]) {
		    swap(toSortNumbers, i - 1, i);
		    swapped = true;
		}
	    }
	    --problemSize;
	} while (swapped);
	return toSortNumbers;
    }

    @Override
    public String getAlgorithmName() {
	return "Bubble Sort";
    }

}
