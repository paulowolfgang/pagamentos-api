package br.gov.pa.sefa.pagamentos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/pagamentos")
public class PagamentoController
{
	private final IStatusPagamentoService statusPagamentoService;
	private final IPagamentoService pagamentoService;
	private final IPagamentoFilterService pagamentoFilterService;
	    
	@GetMapping
    public ResponseEntity<List<PagamentoFilterResponse>> obterPagamentos(PagamentoFilterRequest request) {
    List<PagamentoFilterResponse> pagamentos = pagamentoFilterService.filtrar(request);
    return ResponseEntity.ok().body(pagamentos);
    }
}
