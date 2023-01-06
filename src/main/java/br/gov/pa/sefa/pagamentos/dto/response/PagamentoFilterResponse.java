package br.gov.pa.sefa.pagamentos.dto.response;

import java.math.BigDecimal;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.entity.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
