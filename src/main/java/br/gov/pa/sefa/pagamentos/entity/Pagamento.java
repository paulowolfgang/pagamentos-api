package br.gov.pa.sefa.pagamentos.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
