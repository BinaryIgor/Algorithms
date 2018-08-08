package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service("HeapSortAlgorithmService")
public class HeapSortAlgorithmService extends SortAlgorithmService {

    @Override
    public int[] solve(int[] problem) {
	int[] toSortNumbers = Arrays.copyOf(problem, problem.length);
	sort(toSortNumbers);
	return toSortNumbers;
    }

    private void sort(int[] numbers) {
	buildHeap(numbers);
	for (int i = numbers.length - 1; i > 0; i--) {
	    swap(numbers, 0, i);
	    heapify(numbers, 0, i);
	}
    }

    private void buildHeap(int[] numbers) {
	int n = numbers.length;
	for (int i = n / 2 - 1; i >= 0; i--) {
	    heapify(numbers, i, n);
	}
    }

    private void heapify(int[] numbers, int rootIndex, int size) {
	int largest = rootIndex;
	int left = 2 * rootIndex + 1;
	int right = 2 * rootIndex + 2;
	if (left < size && numbers[left] > numbers[largest]) {
	    largest = left;
	}
	if (right < size && numbers[right] > numbers[largest]) {
	    largest = right;
	}
	if (largest != rootIndex) {
	    swap(numbers, rootIndex, largest);
	    heapify(numbers, largest, size);
	}
    }

    @Override
    public String getAlgorithmName() {
	return "Heap Sort";
    }

}
