package org.serratec.backend.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vendedor")
public abstract class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoVendedor;

    private String nome;

    private String email;

    private BigDecimal salario;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<LancamentoVendas> lancamento;


    public Long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public List<LancamentoVendas> getLancamento() {
        return lancamento;
    }

    public void setLancamento(List<LancamentoVendas> lancamento) {
        this.lancamento = lancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
