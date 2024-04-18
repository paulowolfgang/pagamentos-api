package br.gov.pa.sefa.pagamentos.exception;

public class ValidadorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ValidadorException(String message) {
        super(message);
    }
}