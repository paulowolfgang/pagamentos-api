package br.gov.pa.sefa.pagamentos.dto.request;

import br.gov.pa.sefa.pagamentos.entity.TipoPagamento;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Setter
@Getter
public class PagamentoRequest {

    @CPF
    private String cpf;

    @CNPJ
    private String cnpj;
    private String numeroCartao;

    @NotNull
    @Positive
    private BigDecimal valor;
    private TipoPagamento tipoPagamento;
}
