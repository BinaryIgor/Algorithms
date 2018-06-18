package control.self.igor.algorithms.service.algorithm.general;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import control.self.igor.algorithms.exception.SolverConditionException;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.service.algorithm.AlgorithmService;

@Service
public class SumTwoNumbersAlgorithmService implements AlgorithmService<TwoNumbersAsArrays, int[]> {

    @Override
    public int[] solve(TwoNumbersAsArrays problem) {
	int[] first = problem.getFirst();
	int[] second = problem.getSecond();
	if (first.length > second.length)
	    second = addZerosFromLeft(second, first.length - second.length);
	else if (second.length > first.length)
	    first = addZerosFromLeft(first, second.length - first.length);
	return calculateSum(first, second);
    }

    private int[] addZerosFromLeft(int[] number, int zerosToAdd) {
	int[] newNumber = new int[number.length + zerosToAdd];
	for (int i = zerosToAdd; i < newNumber.length; i++)
	    newNumber[i] = number[i - zerosToAdd];
	return newNumber;
    }

    private int[] calculateSum(int[] first, int[] second) {
	if (first.length != second.length)
	    throw SolverConditionException.createUnequalArraysLengthException();
	int lastPosition = first.length - 1;
	int carry = 0;
	int[] sum = new int[first.length + 1];
	while (lastPosition >= 0) {
	    int total = first[lastPosition] + second[lastPosition] + carry;
	    sum[lastPosition + 1] = total % 10;
	    carry = total > 9 ? 1 : 0;
	    --lastPosition;
	}
	return adjustSumToCarry(sum, carry);
    }

    private int[] adjustSumToCarry(int sum[], int carry) {
	if (carry == 0) {
	    return Arrays.copyOfRange(sum, 1, sum.length);
	}
	sum[0] = carry;
	return sum;
    }

}
