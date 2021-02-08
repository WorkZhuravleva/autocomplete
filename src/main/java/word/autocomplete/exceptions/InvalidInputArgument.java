package word.autocomplete.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidInputArgument extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 401298630740623468L;

}
