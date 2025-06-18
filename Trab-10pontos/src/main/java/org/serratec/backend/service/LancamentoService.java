package org.serratec.backend.service;

import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.LancamentoVendasException;
import org.serratec.backend.repository.LancamentoVendasRepository;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.stereotype.Service;


@Service
public class LancamentoService {

    private final LancamentoVendasRepository lancamentoRepository;
    private final VendedorRepository vendedorRepository;

    public LancamentoService(LancamentoVendasRepository lancamentoRepository, VendedorRepository vendedorRepository) {
        this.lancamentoRepository = lancamentoRepository;
        this.vendedorRepository = vendedorRepository;
    }

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        LancamentoVendas lancamento = lancamentoRepository.findById(id)
                .orElseThrow(() -> new LancamentoVendasException("Lançamento não encontrado"));
        return new LancamentoVendasResponseDTO(lancamento.getDataVenda(), lancamento.getValorVenda(),
                lancamento.getVendedor().getNome());
    }

    public LancamentoVendas inserirLancamento(LancamentoVendasRequestDTO dto) {
        Vendedor vendedor = vendedorRepository.findById(dto.getCodigoVendedor())
                .orElseThrow(() -> new LancamentoVendasException("Vendedor não encontrado"));

        LancamentoVendas lancamento = new LancamentoVendas();
        lancamento.setDataVenda(dto.getDataVenda());
        lancamento.setValorVenda(dto.getValorVenda());
        lancamento.setVendedor(vendedor);

        return lancamentoRepository.save(lancamento);
    }
}
