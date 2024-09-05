package com.financeiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.enums.Situacao;
import com.financeiro.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	
	List<Conta> findBySituacao(Situacao situacao);

}
