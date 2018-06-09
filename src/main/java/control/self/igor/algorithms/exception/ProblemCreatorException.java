package control.self.igor.algorithms.exception;

public class ProblemCreatorException extends RuntimeException {

    private ProblemCreatorException(String message) {
	super(message);
    }

    public static <Problem> ProblemCreatorException createLackOfCreatorException(Class<Problem> clazz) {
	return new ProblemCreatorException("There is no problem creator for " + clazz.getSimpleName() + " type");
    }
}
