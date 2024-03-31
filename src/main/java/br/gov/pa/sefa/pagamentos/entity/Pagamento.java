package br.gov.pa.sefa.pagamentos.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

public class Pagamento {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String cpf;
    private String cnpj;
    private String numeroCartao;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusProcessamento status;
}
