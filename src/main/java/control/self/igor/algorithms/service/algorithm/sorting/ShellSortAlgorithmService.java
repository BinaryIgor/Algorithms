package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("ShellSortAlgorithmService")
public class ShellSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	for (int gap = toSortNumbers.length / 2; gap > 0; gap /= 2) {
	    for (int firstUnsortedIndex = gap; firstUnsortedIndex < toSortNumbers.length; ++firstUnsortedIndex) {
		int newElement = toSortNumbers[firstUnsortedIndex];
		int i = firstUnsortedIndex;
		while (i >= gap && toSortNumbers[i - gap] > newElement) {
		    toSortNumbers[i] = toSortNumbers[i - gap];
		    i -= gap;
		}
		toSortNumbers[i] = newElement;
	    }
	}
	return toSortNumbers;
    }

    @Override
    public String getAlgorithmName() {
	return "Shell Sort";
    }

}
