package br.gov.pa.sefa.pagamentos.exception.handler;

import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoEncontradoException;
import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoPodeSerRemovidoException;
import br.gov.pa.sefa.pagamentos.exception.StatusProcessamentoNaoAlteradoException;
import br.gov.pa.sefa.pagamentos.exception.ValidadorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PagamentoNaoEncontradoException.class)
    public ResponseEntity<ApiError> handlerPagamentoNaoEncontradoException(PagamentoNaoEncontradoException ex) {
        ApiError apiError = new ApiError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(PagamentoNaoPodeSerRemovidoException.class)
    public ResponseEntity<ApiError> handlerPagamentoNaoPodeSerRemovidoException(PagamentoNaoPodeSerRemovidoException ex) {
        ApiError apiError = new ApiError(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(StatusProcessamentoNaoAlteradoException.class)
    public ResponseEntity<ApiError> handlerStatusProcessamentoNaoAlteradoException(StatusProcessamentoNaoAlteradoException ex) {
        ApiError apiError = new ApiError(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(ValidadorException.class)
    public ResponseEntity<ApiError> handlerValidadorException(ValidadorException ex) {
        ApiError apiError = new ApiError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ValidationError validationError = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Error na validação dos campos!");
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
                });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
