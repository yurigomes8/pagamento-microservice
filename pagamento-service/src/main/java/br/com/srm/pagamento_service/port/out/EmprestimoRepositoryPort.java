package br.com.srm.pagamento_service.port.out;

import br.com.srm.pagamento_service.domain.EmprestimoDomain;
import br.com.srm.pagamento_service.entities.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public interface EmprestimoRepositoryPort {
    Emprestimo findFirstById(Long id);
    void save(EmprestimoDomain emprestimoDomain);
}
