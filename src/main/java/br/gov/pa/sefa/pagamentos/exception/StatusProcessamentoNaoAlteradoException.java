package br.gov.pa.sefa.pagamentos.exception;

public class StatusProcessamentoNaoAlteradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StatusProcessamentoNaoAlteradoException() {
        super("Status não pode ser alterado");
    }
}
