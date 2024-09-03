package br.com.srm.pagamento_service.domain;

import br.com.srm.pagamento_service.entities.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EmprestimoDomain {
    private Long id;
    private Double valorEmprestimo;
    private Integer numeroParcelas;
    private String statusPagamento;
    private LocalDate dataPagamento;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizacao;
    private Pessoa pessoa;

    public void marcarComoPago() {
        this.statusPagamento = "Pago";
        this.dataAtualizacao = LocalDate.now();
    }

    public boolean isPago() {
        return "Pago".equals(this.statusPagamento);
    }
}
