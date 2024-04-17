package br.gov.pa.sefa.pagamentos.controller;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.request.PagamentoRequest;
import br.gov.pa.sefa.pagamentos.dto.request.StatusPagmentoRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoResponse;
import br.gov.pa.sefa.pagamentos.service.IPagamentoFilterService;
import br.gov.pa.sefa.pagamentos.service.IPagamentoService;
import br.gov.pa.sefa.pagamentos.service.IStatusPagamentoService;
import br.gov.pa.sefa.pagamentos.service.validator.IValidarCriacaoPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/pagamentos")
public class PagamentoController {

    private final IStatusPagamentoService statusPagamentoService;
    private final IPagamentoService pagamentoService;
    private final IPagamentoFilterService pagamentoFilterService;

    @GetMapping
    public ResponseEntity<List<PagamentoFilterResponse>> obterPagamentos(PagamentoFilterRequest request) {
        List<PagamentoFilterResponse> pagamentos = pagamentoFilterService.filtrar(request);
        return ResponseEntity.ok().body(pagamentos);
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> salvar(@Valid @RequestBody PagamentoRequest request) {
        PagamentoResponse pagamentoResponse = pagamentoService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);
    }

    @PutMapping("/{codigoPagamento}")
    public ResponseEntity<Void> atualizarStatusPagamento(@PathVariable Integer codigoPagamento, @RequestBody StatusPagmentoRequest status ) {
        statusPagamentoService.atualizarStatus(codigoPagamento, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{codigoPagamento}")
    public ResponseEntity<Void> removerPagamento(@PathVariable Integer codigoPagamento) {
        pagamentoService.remover(codigoPagamento);
        return ResponseEntity.noContent().build();
    }
}
