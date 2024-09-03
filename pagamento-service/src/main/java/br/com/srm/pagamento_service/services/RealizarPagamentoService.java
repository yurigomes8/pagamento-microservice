package br.com.srm.pagamento_service.services;

import br.com.srm.pagamento_service.domain.EmprestimoDomain;
import br.com.srm.pagamento_service.entities.Emprestimo;
import br.com.srm.pagamento_service.port.in.RealizarPagamentoUseCasePort;
import br.com.srm.pagamento_service.port.out.EmprestimoRepositoryPort;
import br.com.srm.pagamento_service.repositories.EmprestimoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealizarPagamentoService implements RealizarPagamentoUseCasePort {

    @Autowired
    private EmprestimoRepositoryPort emprestimoRepositoryPort;

    @Autowired
    EmprestimoRepository emprestimoRepository;
    @Override
    @Transactional
    public void realizarPagamento(Long idEmprestimo) {

        EmprestimoDomain emprestimoDomain = emprestimoRepository.findById(idEmprestimo).map(Emprestimo::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado."));


        if (!emprestimoDomain.isPago()) {
            emprestimoDomain.marcarComoPago();
            emprestimoRepositoryPort.save(emprestimoDomain);
        }
    }
}
