package br.com.srm.pagamento_service.entities;

import br.com.srm.pagamento_service.domain.EmprestimoDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "data_atualizacao")
    private LocalDate dataAtualizacao;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "numero_parcelas")
    private Integer numeroParcelas;

    @Column(name = "status_pagamento")
    private String statusPagamento;

    @Column(name = "valor_emprestimo")
    private Double valorEmprestimo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;




    public static Emprestimo fromDomain(EmprestimoDomain emprestimoDomain) {
        Emprestimo entity = new Emprestimo();
        entity.setId(emprestimoDomain.getId());
        entity.setValorEmprestimo(emprestimoDomain.getValorEmprestimo());
        entity.setNumeroParcelas(emprestimoDomain.getNumeroParcelas());
        entity.setStatusPagamento(emprestimoDomain.getStatusPagamento());
        entity.setDataPagamento(emprestimoDomain.getDataPagamento());
        entity.setDataCriacao(emprestimoDomain.getDataCriacao());
        entity.setDataAtualizacao(emprestimoDomain.getDataAtualizacao());
        entity.setPessoa(emprestimoDomain.getPessoa());
        return entity;
    }

    public EmprestimoDomain toDomain() {
        EmprestimoDomain emprestimoDomain = new EmprestimoDomain();
        emprestimoDomain.setId(this.id);
        emprestimoDomain.setValorEmprestimo(this.valorEmprestimo);
        emprestimoDomain.setNumeroParcelas(this.numeroParcelas);
        emprestimoDomain.setStatusPagamento(this.statusPagamento);
        emprestimoDomain.setDataPagamento(this.dataPagamento);
        emprestimoDomain.setDataCriacao(this.dataCriacao);
        emprestimoDomain.setDataAtualizacao(this.dataAtualizacao);
        emprestimoDomain.setPessoa(this.pessoa);
        return emprestimoDomain;
    }
}
