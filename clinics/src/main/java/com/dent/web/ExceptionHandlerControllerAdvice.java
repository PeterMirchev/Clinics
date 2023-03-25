package com.dent.web;
import com.dent.exception.ExceptionMessages;
import com.dent.exception.InvalidEntityDataException;
import com.dent.exception.NonExistingEntityException;
import com.dent.model.dto.expose.ExceptionResponseDTO;
import jakarta.servlet.http.PushBuilder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleNonExistingEntityException(NonExistingEntityException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponseDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleInvalidEntityDataException(InvalidEntityDataException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), ExceptionMessages.INVALID_DATA_PROVIDED, exception.getConstraintViolations()));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> fieldErrorMessages = exception.getFieldErrors()
                .stream()
                .map(e -> String.format(ExceptionMessages.FIELD_ERROR_MESSAGE, e.getDefaultMessage(), e.getField(), e.getRejectedValue()))
                .toList();
        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), ExceptionMessages.INVALID_DATA_PROVIDED, fieldErrorMessages));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseDTO> handleSqlIntegrityException(DataIntegrityViolationException exception) {
        String e = exception.getCause().getCause().getLocalizedMessage();
        if (e.startsWith("Duplicate entry")) {
            e = e.split(" for key ")[0];
        } else {
            e = exception.getMessage();
        }
        return ResponseEntity
                .badRequest()
                .body(new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), e));
    }
}
