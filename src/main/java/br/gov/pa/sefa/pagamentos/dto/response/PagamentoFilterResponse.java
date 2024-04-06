package br.gov.pa.sefa.pagamentos.dto.response;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.entity.TipoPagamento;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoFilterResponse {

    private Integer codigo;
    private String cpf;
    private String cnpj;
    private BigDecimal valor;
    private String numeroCartao;
    private TipoPagamento tipoPagamento;
    private StatusProcessamento status;
}
