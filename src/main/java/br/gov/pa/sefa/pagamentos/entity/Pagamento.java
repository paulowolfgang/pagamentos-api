package br.gov.pa.sefa.pagamentos.entity;

import java.math.BigDecimal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;

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
