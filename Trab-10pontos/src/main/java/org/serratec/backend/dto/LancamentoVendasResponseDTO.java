package org.serratec.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, BigDecimal valorVenda, String nomeVendedor) {
}
