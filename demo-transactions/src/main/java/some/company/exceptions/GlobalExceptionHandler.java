package some.company.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import some.company.exceptions.impl.FieldsNotParsableException;
import some.company.exceptions.impl.OldTransactionException;
import some.company.exceptions.impl.TransactionInFutureException;

@RestControllerAdvice
public class GlobalExceptionHandler
    extends ResponseEntityExceptionHandler {

    /**
     * Handles malformed JSON that cannot be parsed.
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(OldTransactionException.class)
    public final ResponseEntity<?> handleNoContent() {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler({FieldsNotParsableException.class, TransactionInFutureException.class})
    public final ResponseEntity<?> handleUnprocessableEntity() {
        return ResponseEntity.unprocessableEntity().build();
    }

    /**
     * Handles all other error cases, resulting to Internal Server Error (500).
     */
    @ExceptionHandler({
        Exception.class, IllegalStateException.class, IllegalArgumentException.class})
    public final ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
