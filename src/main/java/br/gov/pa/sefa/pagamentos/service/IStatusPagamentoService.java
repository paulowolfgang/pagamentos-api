package br.gov.pa.sefa.pagamentos.service;

import br.gov.pa.sefa.pagamentos.dto.request.StatusPagmentoRequest;

public class IStatusPagamentoService {
	void atualizarStatus(Integer codigoPagamento, StatusPagmentoRequest statusPagmento);
	}
}
