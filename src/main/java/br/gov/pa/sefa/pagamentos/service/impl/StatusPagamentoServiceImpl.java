package br.gov.pa.sefa.pagamentos.service.impl;

import br.gov.pa.sefa.pagamentos.dto.request.StatusPagmentoRequest;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepository;
import br.gov.pa.sefa.pagamentos.service.IPagamentoService;
import br.gov.pa.sefa.pagamentos.service.IStatusPagamentoService;
import br.gov.pa.sefa.pagamentos.service.validator.IValidarStatusPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusPagamentoServiceImpl implements IStatusPagamentoService {

    private final IPagamentoRepository pagamentoRepository;
    private final IValidarStatusPagamento validarStatusPagamento;
    private final IPagamentoService pagamentoService;

    @Override
    public void atualizarStatus(Integer codigoPagamento, StatusPagmentoRequest statusPagmento) {
        Pagamento pagamentoAtual = pagamentoService.obterPorId(codigoPagamento);
        validarStatusPagamento.validar(statusPagmento.getStatus(), pagamentoAtual.getStatus());
        pagamentoAtual.setStatus(statusPagmento.getStatus());
        pagamentoRepository.save(pagamentoAtual);
    }
}
