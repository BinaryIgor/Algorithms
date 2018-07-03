package control.self.igor.algorithms.service.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("ShellSortAlgorithmService")
public class ShellSortAlgorithmService extends SortAlgorithmService {

    @Override
    public List<Integer> solve(List<Integer> problem) {
	List<Integer> toSortList = new ArrayList<>(problem);
	for (int gap = toSortList.size() / 2; gap > 0; gap /= 2) {
	    for (int firstUnsortedIndex = gap; firstUnsortedIndex < toSortList.size(); ++firstUnsortedIndex) {
		int newElement = toSortList.get(firstUnsortedIndex);
		int i = firstUnsortedIndex;
		while (i >= gap && toSortList.get(i - gap) > newElement) {
		    toSortList.set(i, toSortList.get(i - gap));
		    i -= gap;
		}
		toSortList.set(i, newElement);
	    }
	}
	return toSortList;
    }

    @Override
    public String getAlgorithmName() {
	return "Shell Sort";
    }

}
