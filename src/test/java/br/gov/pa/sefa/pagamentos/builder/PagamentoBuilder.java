package br.gov.pa.sefa.pagamentos.builder;

import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.entity.TipoPagamento;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PagamentoBuilder {

    public static Optional<Pagamento> pagamentoComStatusPendente() {
        Pagamento pagamento = Pagamento.builder()
                .codigo(1)
                .cpf("01895374250")
                .cnpj("56494417000102")
                .tipoPagamento(TipoPagamento.CARTAO_CREDITO)
                .numeroCartao("5189522327039264")
                .valor(new BigDecimal("300"))
                .status(StatusProcessamento.PENDENTE)
                .build();
        return Optional.of(pagamento);
    }

    public static Pagamento pagamentoComStatusSucesso() {
        return Pagamento.builder()
                .codigo(2)
                .cpf("68155138070")
                .cnpj("52841266000160")
                .tipoPagamento(TipoPagamento.CARTAO_CREDITO)
                .numeroCartao("5313804251588402")
                .valor(new BigDecimal("200"))
                .status(StatusProcessamento.SUCESSO)
                .build();
    }

    public static List<PagamentoFilterResponse> pagamentosFiltrados() {
        PagamentoFilterResponse pagamentoFilterResponse = PagamentoFilterResponse.builder()
                .codigo(2)
                .cpf("68155138070")
                .cnpj("52841266000160")
                .tipoPagamento(TipoPagamento.CARTAO_CREDITO)
                .numeroCartao("5313804251588402")
                .valor(new BigDecimal("200"))
                .status(StatusProcessamento.SUCESSO)
                .build();
        return Collections.singletonList(pagamentoFilterResponse);
    }
}
