package br.gov.pa.sefa.pagamentos.dto.response;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.entity.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class PagamentoResponse {

    private Integer codigo;
    private String cpf;
    private String cnpj;
    private BigDecimal valor;
    private String numeroCartao;
    private TipoPagamento tipoPagamento;
    private StatusProcessamento status;
}
