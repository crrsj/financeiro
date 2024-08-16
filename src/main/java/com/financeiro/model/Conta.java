package com.financeiro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financeiro.enums.Mes;
import com.financeiro.enums.Pagamento;
import com.financeiro.enums.Situacao;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataHora = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private Mes mes;
	
	private int ano;
	@NotBlank(message = "Não pode estar em branco")
	private String nome;
	@NotBlank(message = "Não pode estar em branco")
	private String produtoOuFatura;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataCompra;
	@Enumerated(EnumType.STRING)
	private Pagamento pagamento;
	
	private String cartao;
	
	private int parcelas;
	
	private Double valor;
	
	private Double  total;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	
	

}
