package control.self.igor.algorithms.exception;

public class CreatorException extends RuntimeException {

    private CreatorException(String message) {
	super(message);
    }

    public static <Problem> CreatorException createLackOfCreatorException(Class<Problem> clazz) {
	return new CreatorException("There is no Creator for " + clazz.getSimpleName() + " type");
    }
}
