package br.gov.pa.sefa.pagamentos.exception;

public class PagamentoNaoPodeSerRemovidoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PagamentoNaoPodeSerRemovidoException() {
        super("Pagamentos com status Sucesso ou Falha não podem ser removidos");
    }
}
