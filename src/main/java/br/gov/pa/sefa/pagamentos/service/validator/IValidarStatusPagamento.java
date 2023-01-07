package br.gov.pa.sefa.pagamentos.service.validator;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;

public class IValidarStatusPagamento {
	void validar(StatusProcessamento statusRequest, StatusProcessamento statusAtual);
}
