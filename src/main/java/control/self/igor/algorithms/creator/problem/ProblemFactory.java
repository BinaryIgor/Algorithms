package control.self.igor.algorithms.creator.problem;

import java.util.List;

import control.self.igor.algorithms.exception.CreatorException;
import control.self.igor.algorithms.model.problem.TwoNumbersAsArrays;
import control.self.igor.algorithms.model.problem.TwoNumbersAsIntegers;

public class ProblemFactory {

    public static <Problem> Problem create(Class<Problem> clazz) {
	ProblemCreator<Problem> creator = getProblemCreator(clazz);
	return creator.create();
    }

    public static <Problem> List<Problem> create(Class<Problem> clazz, int problemsNumber) {
	ProblemCreator<Problem> creator = getProblemCreator(clazz);
	return creator.create(problemsNumber);
    }

    private static <Problem> ProblemCreator<Problem> getProblemCreator(Class<Problem> clazz) {
	if (clazz.isAssignableFrom(TwoNumbersAsArrays.class))
	    return (ProblemCreator<Problem>) new SumTwoNumbersProblemCreator().create();
	else if (clazz.isAssignableFrom(TwoNumbersAsIntegers.class))
	    return (ProblemCreator<Problem>) new GreatestCommonDenominatorProblemCreator().create();
	throw CreatorException.createLackOfCreatorException(clazz);
    }
}
