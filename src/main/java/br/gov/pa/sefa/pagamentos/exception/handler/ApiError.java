package br.gov.pa.sefa.pagamentos.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiError {
    private Long timestamp;
    private Integer statusCode;
    private String error;
}
