package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("InsertionSortAlgorithmService")
public class InsertionSortAlgorithmService extends SortAlgorithmService {

    @Override
    public List<Integer> solve(List<Integer> problem) {
	List<Integer> toSortList = new ArrayList<>(problem);
	for (int firstUnsortedIndex = 1; firstUnsortedIndex < problem.size(); firstUnsortedIndex++) {
	    int newElement = toSortList.get(firstUnsortedIndex);
	    int i;
	    for (i = firstUnsortedIndex; i > 0 && newElement < toSortList.get(i - 1); i--) {
		toSortList.set(i, toSortList.get(i - 1));
	    }
	    toSortList.set(i, newElement);
	}
	return toSortList;
    }

    @Override
    public String getAlgorithmName() {
	return "Insertion Sort";
    }

}
