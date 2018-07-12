package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("SelectionSortAlgorithmService")
public class SelectionSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	for (int i = toSortNumbers.length - 1; i > 0; --i) {
	    int maxIndex = 0;
	    for (int j = 1; j <= i; j++) {
		if (toSortNumbers[i] > toSortNumbers[maxIndex]) {
		    maxIndex = j;
		}
	    }
	    if (toSortNumbers[maxIndex] > toSortNumbers[i]) {
		swap(toSortNumbers, maxIndex, i);
	    }
	}
	return toSortNumbers;
    }

    @Override
    public String getAlgorithmName() {
	return "Selection Sort";
    }

}
