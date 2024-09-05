package com.financeiro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financeiro.enums.Situacao;
import com.financeiro.model.Conta;
import com.financeiro.repository.ContaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaService {
	
	private final ContaRepository contaRepository;
	
	public Conta criar(Conta conta) {		
		conta.setTotal(0.0);
		return contaRepository.save(conta);
	}
	
	
	  public List<Conta> buscarContas() {
	        return contaRepository.findAll();
	    }

	  public Double valorTotal() {
	        return contaRepository.findAll().stream()
	            .mapToDouble(Conta::getValor)
	            .sum();
	    }
	
	public void excluir(Long id) {
		contaRepository.deleteById(id);
		
	}
	
	public Conta buscarPorId(Long id) {
		Optional<Conta> buscar = contaRepository.findById(id);
		return buscar.get();
	}
	
	public List<Conta>buscarPagas(){
		return contaRepository.findBySituacao(Situacao.PAGA);
	}
	
	public List<Conta>buscarInadimplentes(){
		return contaRepository.findBySituacao(Situacao.INADIMPLENTE);
	}
	
	public Conta atualizarConta(Conta conta) {
		return contaRepository.save(conta);
	}
}
