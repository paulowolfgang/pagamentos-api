package br.gov.pa.sefa.pagamentos.service;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;

import java.util.List;

public interface IPagamentoFilterService {

    List<PagamentoFilterResponse> filtrar(PagamentoFilterRequest request);

}
