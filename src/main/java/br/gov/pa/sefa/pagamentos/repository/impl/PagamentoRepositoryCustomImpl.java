package br.gov.pa.sefa.pagamentos.repository.impl;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PagamentoRepositoryCustomImpl implements IPagamentoRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<Pagamento> filtrar(PagamentoFilterRequest request) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pagamento> query = builder.createQuery(Pagamento.class);
        Root<Pagamento> pagamento = query.from(Pagamento.class);
        List<Predicate> predicates = new ArrayList<>();
        if (request.getCodigo() != null) {
            predicates.add(builder.equal(pagamento.get("codigo"), request.getCodigo()));
        }
        if (request.getCpf() != null) {
            predicates.add(builder.equal(pagamento.get("cpf"), request.getCpf()));
        }
        if (request.getCnpj() != null) {
            predicates.add(builder.equal(pagamento.get("cnpj"), request.getCnpj()));
        }
        if (request.getStatus() != null) {
            predicates.add(builder.equal(pagamento.get("status"), request.getStatus()));
        }
        if (!predicates.isEmpty()) {
            query.where(predicates.stream().toArray(Predicate[]::new));
        }
        TypedQuery<Pagamento> queryResult = entityManager.createQuery(query);
        return queryResult.getResultList();
    }
}
