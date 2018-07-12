package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("QuickSortAlgorithmService")
public class QuickSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	sort(toSortNumbers, 0, toSortNumbers.length - 1);
	return toSortNumbers;
    }

    private void sort(int[] toSortNumbers, int start, int end) {
	int pivotIndex = (start + end) / 2;
	int pivotValue = toSortNumbers[pivotIndex];
	int i = start;
	int j = end;
	while (i < j) {
	    while (toSortNumbers[i] < pivotValue) {
		i++;
	    }
	    while (toSortNumbers[j] > pivotValue) {
		j--;
	    }
	    if (i <= j) {
		swap(toSortNumbers, i, j);
		i++;
		j--;
	    }
	}
	if (i < end) {
	    sort(toSortNumbers, i, end);
	}
	if (start < j) {
	    sort(toSortNumbers, start, j);
	}
    }

    @Override
    public String getAlgorithmName() {
	return "Quick Sort";
    }

}
