package br.gov.pa.sefa.pagamentos.service;

import br.gov.pa.sefa.pagamentos.dto.request.StatusPagmentoRequest;

public interface IStatusPagamentoService {
    void atualizarStatus(Integer codigoPagamento, StatusPagmentoRequest statusPagmento);
}
