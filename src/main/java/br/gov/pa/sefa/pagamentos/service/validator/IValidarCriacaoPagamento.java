package br.gov.pa.sefa.pagamentos.service.validator;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoRequest;

public interface IValidarCriacaoPagamento {

    void validar(PagamentoRequest request);

}
