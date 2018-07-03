package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("SelectionSortAlgorithmService")
public class SelectionSortAlgorithmService extends SortAlgorithmService {

    @Override
    public List<Integer> solve(List<Integer> problem) {
	List<Integer> toSortList = new ArrayList<>(problem);
	for (int i = toSortList.size() - 1; i > 0; --i) {
	    int maxIndex = 0;
	    for (int j = 1; j <= i; j++) {
		if (toSortList.get(j) > toSortList.get(maxIndex)) {
		    maxIndex = j;
		}
	    }
	    if (toSortList.get(maxIndex) > toSortList.get(i)) {
		swap(toSortList, maxIndex, i);
	    }
	}
	return toSortList;
    }

    @Override
    public String getAlgorithmName() {
	return "Selection Sort";
    }

}
