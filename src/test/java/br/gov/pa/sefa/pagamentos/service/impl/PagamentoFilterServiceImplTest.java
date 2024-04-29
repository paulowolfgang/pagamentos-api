package br.gov.pa.sefa.pagamentos.service.impl;

import br.gov.pa.sefa.pagamentos.builder.PagamentoBuilder;
import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepositoryCustom;
import br.gov.pa.sefa.pagamentos.service.IPagamentoFilterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PagamentoFilterServiceImplTest {

    @Mock
    private IPagamentoRepositoryCustom pagamentoRepository;
    private IPagamentoFilterService pagamentoFilterService;
    private Pagamento pagamento;

    @BeforeEach
    void init() {
        pagamentoFilterService = new PagamentoFilterServiceImpl(pagamentoRepository);
        pagamento = PagamentoBuilder.pagamentoComStatusSucesso();
    }

    @Test
    void deveRetornaListaPagamentosFiltrados() {
        when(pagamentoRepository.filtrar(any(PagamentoFilterRequest.class))).thenReturn(Collections.singletonList(pagamento));
        List<PagamentoFilterResponse> pagamentosFiltrados = pagamentoFilterService.filtrar(any());
        assertNotNull(pagamentosFiltrados);
    }
}