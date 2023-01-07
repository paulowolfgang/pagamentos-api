package br.gov.pa.sefa.pagamentos.service.impl;

import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoEncontradoException;
import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoPodeSerRemovidoException;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepository;
import br.gov.pa.sefa.pagamentos.service.IPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagamentoServiceImpl implements IPagamentoService {

    private final IPagamentoRepository pagamentoRepository;

    @Override
    public void remover(Integer codigoPagamento) {
        try {
            Pagamento pagamentoAtual = obterPorId(codigoPagamento);
            if (!pagamentoAtual.getStatus().equals(StatusProcessamento.PENDENTE)) {
                throw new PagamentoNaoPodeSerRemovidoException();
            }
            pagamentoRepository.deleteById(pagamentoAtual.getCodigo());
        } catch (EmptyResultDataAccessException e) {
            throw new PagamentoNaoEncontradoException(codigoPagamento);
        }
    }

    @Override
    public Pagamento obterPorId(Integer codigo) {
        Optional<Pagamento> pagamentoAtual = pagamentoRepository.findById(codigo);
        if (pagamentoAtual.isEmpty()) {
            throw new PagamentoNaoEncontradoException(codigo);
        }
        return pagamentoAtual.get();
    }
}
