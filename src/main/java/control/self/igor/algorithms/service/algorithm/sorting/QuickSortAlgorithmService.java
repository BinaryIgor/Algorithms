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
	if (end <= start) {
	    return;
	}
	int pivot = getPivot(toSortNumbers, start, end), i = start, j = end;
	while (i < j) {
	    while (toSortNumbers[i] < pivot) {
		i++;
	    }
	    while (toSortNumbers[j] > pivot) {
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

    private int getPivot(int[] toSortNumbers, int start, int end) {
	if ((end - start) <= 2) {
	    return toSortNumbers[start];
	}
	int first = toSortNumbers[start], second = toSortNumbers[(start + end + 1) / 2], third = toSortNumbers[end];
	if (first < third) {
	    return second > third ? third : second;
	}
	return second > first ? first : second;
    }

    @Override
    public String getAlgorithmName() {
	return "Quick Sort";
    }

}
