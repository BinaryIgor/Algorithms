package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("MergeSortAlgorithmService")
public class MergeSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	sort(toSortNumbers, 0, toSortNumbers.length);
	return toSortNumbers;
    }

    private void sort(int[] toSortNumbers, int start, int end) {
	if ((end - start) < 2) {
	    return;
	}
	int mid = (start + end) / 2;
	sort(toSortNumbers, start, mid);
	sort(toSortNumbers, mid, end);
	merge(toSortNumbers, start, mid, end);
    }

    private void merge(int[] toSortNumbers, int start, int mid, int end) {
	if (toSortNumbers[mid - 1] <= toSortNumbers[mid]) {
	    return;
	}
	int firstArrayIndex = start, secondArrayIndex = mid, tmpIndex = 0;
	int[] tmp = new int[end - start];
	for (; firstArrayIndex < mid && secondArrayIndex < end; ++tmpIndex) {
	    if (toSortNumbers[firstArrayIndex] <= toSortNumbers[secondArrayIndex]) {
		tmp[tmpIndex] = toSortNumbers[firstArrayIndex];
		++firstArrayIndex;
	    } else {
		tmp[tmpIndex] = toSortNumbers[secondArrayIndex];
		++secondArrayIndex;
	    }
	}
	while (firstArrayIndex < mid) {
	    tmp[tmpIndex++] = toSortNumbers[firstArrayIndex++];
	}
	for (int i = 0; i < tmpIndex; ++i) {
	    toSortNumbers[start + i] = tmp[i];
	}
    }

    @Override
    public String getAlgorithmName() {
	return "Merge Sort";
    }

}
