package swa.hotel.service.validator;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractValidator {

    private static final String FIELD_MISSING_MSG = "FIELD MISSING: %s";

    protected void notFound(String message) {

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
    }

    protected void field_missing(String field) {

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(FIELD_MISSING_MSG, field));
    }
}
