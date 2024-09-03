package br.com.srm.pagamento_service.adapters.out;

import br.com.srm.pagamento_service.domain.EmprestimoDomain;
import br.com.srm.pagamento_service.entities.Emprestimo;
import br.com.srm.pagamento_service.port.out.EmprestimoRepositoryPort;
import br.com.srm.pagamento_service.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoRepositoryPortAdapter implements EmprestimoRepositoryPort {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Override
    public Emprestimo findFirstById(Long id) {
        return emprestimoRepository.findFirstById(id);
    }

    @Override
    public void save(EmprestimoDomain emprestimoDomain) {
        emprestimoRepository.save(Emprestimo.fromDomain(emprestimoDomain));
    }
}
