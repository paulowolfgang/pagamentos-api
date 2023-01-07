package br.gov.pa.sefa.pagamentos.exception.handler;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends ApiError {
    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Long timestamp, Integer statusCode, String error) {
        super(timestamp, statusCode, error);
    }

    public void addError(String fieldName, String messageError) {
        this.erros.add(new FieldMessage(fieldName, messageError));
    }
}
