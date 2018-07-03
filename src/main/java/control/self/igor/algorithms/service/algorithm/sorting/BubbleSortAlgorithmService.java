package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("BubbleSortAlgorithmService")
public class BubbleSortAlgorithmService extends SortAlgorithmService {

    @Override
    public List<Integer> solve(List<Integer> problem) {
	List<Integer> toSortList = new ArrayList<>(problem);
	int problemSize = toSortList.size();
	boolean swapped;
	do {
	    swapped = false;
	    for (int i = 1; i < problemSize; i++) {
		if (toSortList.get(i) < toSortList.get(i - 1)) {
		    swap(toSortList, i - 1, i);
		    swapped = true;
		}
	    }
	    --problemSize;
	} while (swapped);
	return toSortList;
    }

    @Override
    public String getAlgorithmName() {
	return "Bubble Sort";
    }

}
