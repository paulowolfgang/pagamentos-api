package br.gov.pa.sefa.pagamentos.service.impl;

import br.gov.pa.sefa.pagamentos.dto.mapper.PagamentoFilterMapper;
import br.gov.pa.sefa.pagamentos.dto.request.PagamentoFilterRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import br.gov.pa.sefa.pagamentos.repository.IPagamentoRepositoryCustom;
import br.gov.pa.sefa.pagamentos.service.IPagamentoFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoFilterServiceImpl implements IPagamentoFilterService {

    private final IPagamentoRepositoryCustom pagamentoRepository;

    @Override
    public List<PagamentoFilterResponse> filtrar(PagamentoFilterRequest request) {
        List<Pagamento> pagamentos = pagamentoRepository.filtrar(request);
        return PagamentoFilterMapper.converter(pagamentos);
    }
}
