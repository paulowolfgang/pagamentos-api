package br.gov.pa.sefa.pagamentos.repository;


import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;

public interface IPagamentoFilterRepository {

    PagamentoFilterResponse filtrarPorCodigo(PagamentoFilterRequest filter);

    PagamentoFilterResponse filtrarPorCpfOuCnpj(PagamentoFilterRequest filter);

    PagamentoFilterResponse filtrarPorStatus(PagamentoFilterRequest filter);

}
