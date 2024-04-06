package br.gov.pa.sefa.pagamentos.dto.mapper;

import br.gov.pa.sefa.pagamentos.dto.request.PagamentoRequest;
import br.gov.pa.sefa.pagamentos.dto.response.PagamentoResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;
import org.modelmapper.ModelMapper;

public class PagamentoMapper {

    private static final ModelMapper mapper = new ModelMapper();

    public static PagamentoResponse converter(Pagamento pagamento) {
        return mapper.map(pagamento, PagamentoResponse.class);
    }

    public static Pagamento converter(PagamentoRequest request) {
        return mapper.map(request, Pagamento.class);
    }

    public static void copyToProperties(PagamentoRequest request, Pagamento pagamento) {
        mapper.map(request, pagamento);
    }

}
