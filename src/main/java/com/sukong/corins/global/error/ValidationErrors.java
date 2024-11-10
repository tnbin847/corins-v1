package com.sukong.corins.global.error;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by 박 수 빈 on 24. 11. 9.
 */

@Getter
public class ValidationErrors {
    private final String field;
    private final String value;
    private final String message;

    private ValidationErrors(String field, String value, String message) {
        this.field = field;
        this.value = value;
        this.message = message;
    }

    private static String nullSafeToString(Object object) {
        return object == null ? "" : object.toString();
    }

    private static String parsingPropertyFrom(String propertyPath) {
        int lastIndex = propertyPath.lastIndexOf('.');
        return lastIndex == -1 ? propertyPath : propertyPath.substring(lastIndex + 1);
    }

    public static List<ValidationErrors> of(final String field, final String value, final String message) {
        final List<ValidationErrors> errors = new ArrayList<>();
        errors.add(new ValidationErrors(field, value, message));
        return errors;
    }

    public static List<ValidationErrors> of(final BindingResult bindingResult) {
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return fieldErrors.stream().map(fieldError -> new ValidationErrors(
                fieldError.getField(),
                nullSafeToString(fieldError.getRejectedValue()),
                fieldError.getDefaultMessage()
        )).collect(Collectors.toList());
    }

    public static List<ValidationErrors> of(final Set<ConstraintViolation<?>> violations) {
        final List<ConstraintViolation<?>> constraintViolations = new ArrayList<>(violations);
        return constraintViolations.stream().map(constraintViolation -> new ValidationErrors(
                parsingPropertyFrom(constraintViolation.getPropertyPath().toString()),
                nullSafeToString(constraintViolation.getInvalidValue()),
                constraintViolation.getMessage()
        )).collect(Collectors.toList());
    }
}