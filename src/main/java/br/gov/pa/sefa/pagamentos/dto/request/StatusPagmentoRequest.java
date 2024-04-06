package br.gov.pa.sefa.pagamentos.dto.request;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StatusPagmentoRequest {

    private StatusProcessamento status;
}
