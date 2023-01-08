package br.gov.pa.sefa.pagamentos.service.impl;

import br.gov.pa.sefa.pagamentos.dto.mapper.PagamentoMapper;
import br.gov.pa.sefa.pagamentos.dto.request.PagamentoRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoEncontradoException;
import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoPodeSerRemovidoException;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepository;
import br.gov.pa.sefa.pagamentos.service.IPagamentoService;
import br.gov.pa.sefa.pagamentos.service.validator.IValidarCriacaoPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagamentoServiceImpl implements IPagamentoService {

    private final IPagamentoRepository pagamentoRepository;
    private final IValidarCriacaoPagamento validarCriacaoPagamento;

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

    @Override
    public PagamentoResponse salvar(PagamentoRequest request) {
        validarCriacaoPagamento.validar(request);
        Pagamento pagamento = PagamentoMapper.converter(request);
        pagamento.setStatus(StatusProcessamento.PENDENTE);
        pagamento = pagamentoRepository.save(pagamento);
        return PagamentoMapper.converter(pagamento);
    }
}
