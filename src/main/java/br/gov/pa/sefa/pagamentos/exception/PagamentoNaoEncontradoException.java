package br.gov.pa.sefa.pagamentos.exception;

public class PagamentoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PagamentoNaoEncontradoException(String message) {
        super(message);
    }

    public PagamentoNaoEncontradoException(Integer codigo) {
        this("Não existe pagamento com código: " + codigo);
    }
}
