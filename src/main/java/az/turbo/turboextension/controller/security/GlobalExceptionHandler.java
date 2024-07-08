package az.turbo.turboextension.controller.security;

import az.turbo.turboextension.dtos.security.StandardErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@CrossOrigin(origins = "http://localhost:3000")
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardErrorDTO> exception(Exception ex, HttpServletRequest request) {
        return ResponseEntity.badRequest().body(
                new StandardErrorDTO(HttpStatus.BAD_REQUEST, ex, request));
    }
}