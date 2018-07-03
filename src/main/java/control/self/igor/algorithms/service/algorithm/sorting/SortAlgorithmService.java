package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.List;

import control.self.igor.algorithms.service.algorithm.AlgorithmService;

public abstract class SortAlgorithmService implements AlgorithmService<List<Integer>, List<Integer>> {

    protected void swap(List<Integer> items, int firstIndex, int secondIndex) {
	Integer first = items.get(firstIndex);
	Integer second = items.get(secondIndex);
	items.set(firstIndex, second);
	items.set(secondIndex, first);
    }
}
