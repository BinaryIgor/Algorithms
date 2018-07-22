package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.util.NumberGeneratorUtil;
import control.self.igor.algorithms.util.StringUtil;

@Service("MedianSortAlgorithmService")
public class MedianSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	sort(toSortNumbers, 0, toSortNumbers.length - 1);
	return toSortNumbers;
    }

    private void sort(int[] numbers, int start, int end) {
	if (end <= start) {
	    return;
	}
	int mid = (start + end + 1) / 2;
	int pivotIndex = selectPivotIndex(numbers, start, end);
	int median = regroupAroundPivot(numbers, start, end, pivotIndex);
	System.out.println("After regrouping around median of index = " + pivotIndex);
	System.out.println(StringUtil.arrayToString(numbers));
    }

    private int selectPivotIndex(int[] numbers, int left, int right) {
	return NumberGeneratorUtil.generateNumber(left, right - 1);
    }

    private int regroupAroundPivot(int[] numbers, int left, int right, int pivotIndex) {
	int newPivotIndex = left;
	swap(numbers, pivotIndex, right);
	for (int i = 0; i < right; i++) {
	    if (numbers[i] >= numbers[pivotIndex]) {
		swap(numbers, i, newPivotIndex);
		++newPivotIndex;
	    }
	}
	swap(numbers, newPivotIndex, right);
	return newPivotIndex;
    }

    @Override
    public String getAlgorithmName() {
	return "Median Sort";
    }

}
