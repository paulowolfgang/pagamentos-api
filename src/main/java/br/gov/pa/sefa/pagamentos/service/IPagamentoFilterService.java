package br.gov.pa.sefa.pagamentos.service;

import java.util.List;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;

public class IPagamentoFilterService {
	List<PagamentoFilterResponse> filtrar(PagamentoFilterRequest request);
}
