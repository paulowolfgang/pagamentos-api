package br.gov.pa.sefa.pagamentos.service.validator.impl;

import br.gov.pa.sefa.pagamentos.entity.StatusProcessamento;
import br.gov.pa.sefa.pagamentos.exception.StatusProcessamentoNaoAlteradoException;
import br.gov.pa.sefa.pagamentos.service.validator.IValidarStatusPagamento;
import org.springframework.stereotype.Component;

@Component
public class ValidarStatusProcessamentoImpl implements IValidarStatusPagamento {
    @Override
    public void validar(StatusProcessamento statusRequest, StatusProcessamento statusAtual) {
        if (statusAtual.equals(StatusProcessamento.SUCESSO)) {
            throw new StatusProcessamentoNaoAlteradoException();
        }
        if (statusAtual.equals(StatusProcessamento.FALHA) && statusRequest.equals(StatusProcessamento.SUCESSO)) {
            throw new StatusProcessamentoNaoAlteradoException();
        }
    }
}
