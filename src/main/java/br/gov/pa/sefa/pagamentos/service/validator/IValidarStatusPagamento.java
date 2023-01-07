package br.gov.pa.sefa.pagamentos.service.validator;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;

public interface IValidarStatusPagamento {
    void validar(StatusProcessamento statusRequest, StatusProcessamento statusAtual);
}
