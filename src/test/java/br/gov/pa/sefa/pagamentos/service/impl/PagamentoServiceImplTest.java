package br.gov.pa.sefa.pagamentos.service.impl;

import br.gov.pa.sefa.pagamentos.builder.PagamentoBuilder;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.exception.PagamentoNaoEncontradoException;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepository;
import br.gov.pa.sefa.pagamentos.service.IPagamentoService;
import br.gov.pa.sefa.pagamentos.service.validator.IValidarCriacaoPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class PagamentoServiceImplTest {

    @Mock
    private IPagamentoRepository pagamentoRepository;
    @Mock
    private IValidarCriacaoPagamento validarCriacaoPagamento;
    private IPagamentoService pagamentoService;
    private Pagamento pagamento;

    @BeforeEach
    void init() {
        pagamentoService = new PagamentoServiceImpl(pagamentoRepository, validarCriacaoPagamento);
        pagamento = PagamentoBuilder.pagamentoComStatusPendente().get();
    }

    @Test
    void deveBuscarPagamentoPorId() {
        when(pagamentoRepository.findById(ArgumentMatchers.any())).thenReturn(PagamentoBuilder.pagamentoComStatusPendente());
        Pagamento pagamentoEsperado = pagamentoService.obterPorId(pagamento.getCodigo());
        assertEquals(pagamentoEsperado.getCpf(), pagamento.getCpf());
        assertEquals(pagamentoEsperado.getCnpj(), pagamento.getCnpj());
        assertEquals(pagamentoEsperado.getNumeroCartao(), pagamento.getNumeroCartao());
    }

    @Test
    void deveRetornarExceptionAoBuscarPagamentoPorId() {
        when(pagamentoRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        try {
            pagamentoService.obterPorId(pagamento.getCodigo());
        } catch (Exception e) {
            assertEquals(PagamentoNaoEncontradoException.class, e.getClass());
        }
    }

    @Test
    void deveRetornarExceptionAoRemoverPagamentoPorId() {
        when(pagamentoRepository.findById(ArgumentMatchers.any())).thenThrow(new EmptyResultDataAccessException(1));
        try {
            pagamentoService.remover(anyInt());
        } catch (Exception e) {
            assertEquals(PagamentoNaoEncontradoException.class, e.getClass());
        }
    }

    @Test
    void deveRemoverPagamentoPorIdComStatusPendente() {
        when(pagamentoRepository.findById(anyInt())).thenReturn(PagamentoBuilder.pagamentoComStatusPendente());
        doNothing().when(pagamentoRepository).deleteById(anyInt());
        pagamentoService.remover(anyInt());
        verify(pagamentoRepository, times(1)).deleteById(anyInt());
    }
}