package br.gov.pa.sefa.pagamentos.controller;

import br.gov.pa.sefa.pagamentos.dto.request.StatusPagmentoRequest;
import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepositoryCustom;
import br.gov.pa.sefa.pagamentos.service.IPagamentoFilterService;
import br.gov.pa.sefa.pagamentos.service.IPagamentoService;
import br.gov.pa.sefa.pagamentos.service.IStatusPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/pagamentos")
public class PagamentoController {

    private final IStatusPagamentoService statusPagamentoService;
    private final IPagamentoService pagamentoService;
    private final IPagamentoFilterService pagamentoFilterService;

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

    @GetMapping
    public ResponseEntity<List<PagamentoFilterResponse>> obterPagamentos(PagamentoFilterRequest request) {
        List<PagamentoFilterResponse> pagamentos = pagamentoFilterService.filtrar(request);
        return ResponseEntity.ok().body(pagamentos);
    }
}
