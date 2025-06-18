package org.serratec.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;


public class LancamentoVendasRequestDTO {

    @FutureOrPresent(message = "A data da venda deve ser hoje ou no futuro")
    private LocalDate dataVenda;

    @NotNull(message = "O valor da venda é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da venda deve ser maior que zero")
    private BigDecimal valorVenda;

    @NotNull(message = "O código do vendedor é obrigatório")
    private Long codigoVendedor;

    public LancamentoVendasRequestDTO() {
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }
}
