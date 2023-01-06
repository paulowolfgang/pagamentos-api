package br.gov.pa.sefa.pagamentos.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.gov.pa.sefa.pagamentos.dto.response.PagamentoFilterResponse;
import br.gov.pa.sefa.pagamentos.entity.Pagamento;

public class PagamentoFilterMapper {
	private static final ModelMapper mapper = new ModelMapper();

    public static PagamentoFilterResponse converter(Pagamento pagamento) {
        return mapper.map(pagamento, PagamentoFilterResponse.class);
    }

    public static List<PagamentoFilterResponse> converter(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(PagamentoFilterMapper::converter).collect(Collectors.toList());
    }

}
