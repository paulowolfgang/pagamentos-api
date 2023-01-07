package br.gov.pa.sefa.pagamentos.service;

import br.gov.pa.sefa.pagamentos.entity.Pagamento;

public class IPagamentoService {
	void remover(Integer codigo);
    Pagamento obterPorId(Integer codigo);
}
