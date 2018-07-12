package control.self.igor.algorithms.service.algorithm.sorting;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;

public abstract class SortAlgorithmService implements AlgorithmService<int[], int[]> {

    protected void swap(int[] items, int firstIndex, int secondIndex) {
	int tmp = items[firstIndex];
	items[firstIndex] = items[secondIndex];
	items[secondIndex] = tmp;
    }
}
