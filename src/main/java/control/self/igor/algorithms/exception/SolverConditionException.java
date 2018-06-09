package control.self.igor.algorithms.exception;

public class SolverConditionException extends RuntimeException {

    private SolverConditionException(String message) {
	super(message);
    }

    public static SolverConditionException createUnequalArraysLengthException() {
	return new SolverConditionException("Problem arrays have different lengths");
    }
}
