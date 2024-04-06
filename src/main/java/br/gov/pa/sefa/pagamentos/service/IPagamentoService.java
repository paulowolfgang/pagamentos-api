package br.gov.pa.sefa.pagamentos.service;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;

public interface IPagamentoService {
    void remover(Integer codigo);
    Pagamento obterPorId(Integer codigo);

    PagamentoResponse salvar(PagamentoRequest request);

}
