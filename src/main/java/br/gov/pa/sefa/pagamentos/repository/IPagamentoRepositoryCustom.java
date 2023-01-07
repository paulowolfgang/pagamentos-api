package br.gov.pa.sefa.pagamentos.repository;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;

import java.util.List;

public interface IPagamentoRepositoryCustom {
    List<Pagamento> filtrar(PagamentoFilterRequest request);
}
