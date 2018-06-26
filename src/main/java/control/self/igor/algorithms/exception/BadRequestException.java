package control.self.igor.algorithms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private BadRequestException(String message) {
	super(message);
    }

    public static BadRequestException createNotPositiveNumberException() {
	return new BadRequestException("Needed number should have positive value");
    }
}
