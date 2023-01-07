package br.gov.pa.sefa.pagamentos.repository;

import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
