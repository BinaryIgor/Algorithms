package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("InsertionSortAlgorithmService")
public class InsertionSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	for (int firstUnsortedIndex = 1; firstUnsortedIndex < problem.length; firstUnsortedIndex++) {
	    int newElement = toSortNumbers[firstUnsortedIndex];
	    int i;
	    for (i = firstUnsortedIndex; i > 0 && toSortNumbers[i - 1] > newElement; i--) {
		toSortNumbers[i] = toSortNumbers[i - 1];
	    }
	    toSortNumbers[i] = newElement;
	}
	return toSortNumbers;
    }

    @Override
    public String getAlgorithmName() {
	return "Insertion Sort";
    }

}
