package br.gov.pa.sefa.pagamentos.repository;

import br.gov.pa.sefa.pagamentos.entity.Pagamento;

public interface IPagamentoRepositoryCustom {
    List<Pagamento> filtrar(PagamentoFilterRequest request);
}
