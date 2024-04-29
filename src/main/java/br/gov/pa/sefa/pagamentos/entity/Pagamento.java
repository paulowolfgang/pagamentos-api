package br.gov.pa.sefa.pagamentos.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pagamento {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusProcessamento status;

    private String cpf;
    private String cnpj;
    private String numeroCartao;
    private BigDecimal valor;
}
