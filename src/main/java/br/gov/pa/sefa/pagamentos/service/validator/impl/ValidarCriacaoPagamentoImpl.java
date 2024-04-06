package br.gov.pa.sefa.pagamentos.service.validator.impl;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoRequest;
import br.gov.pa.sefa.pagamentos.entity.TipoPagamento;
import br.gov.pa.sefa.pagamentos.exception.ValidadorException;
import br.gov.pa.sefa.pagamentos.service.validator.IValidarCriacaoPagamento;
import org.springframework.stereotype.Component;

@Component
public class ValidarCriacaoPagamentoImpl implements IValidarCriacaoPagamento {

    public void validar(PagamentoRequest request) {
        if (request.getTipoPagamento().equals(TipoPagamento.CARTAO_CREDITO) || request.getTipoPagamento().equals(TipoPagamento.CARTAO_DEBITO)) {
            if (request.getNumeroCartao() == null) {
                throw new ValidadorException("Número de cartão não informado");
            }
        }

        if (request.getCpf() == null && request.getCnpj() == null) {
            throw new ValidadorException("Número do CPF e/ou CNPJ não informado");
        }
    }

}
