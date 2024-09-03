package br.com.srm.pagamento_service.repositories;


import br.com.srm.pagamento_service.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

   Emprestimo findFirstById(Long id);

}
