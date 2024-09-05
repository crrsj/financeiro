package com.financeiro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.model.Conta;
import com.financeiro.service.ContaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("conta")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ContaController {

	private final ContaService contaService;
	
	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de contas") 
    @ApiResponse(responseCode = "201",description = "sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Conta>Criar(@RequestBody @Valid Conta conta){
		var criarConta = contaService.criar(conta);
		return new ResponseEntity<>(criarConta,HttpStatus.CREATED);
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todas as contas")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<Conta>>buscarContas(){
		var busca = contaService.buscarContas();
		return new ResponseEntity<List<Conta>>(busca,HttpStatus.OK);
	}
	
	@GetMapping("/total")
	@Operation(summary = "Rota responsável pela busca de todas as contas somadas")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
    public Map<String, Double> getTotalValue() {
		 Double valorTotal = contaService.valorTotal();
        Map<String, Double> response = new HashMap<>();
        response.put("total", valorTotal);
        return response;
    }
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por excluir todas as contas")
	@ApiResponse(responseCode = "204",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		contaService.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("pagas")
	@Operation(summary = "Rota responsável pela busca de contas pagas")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<Conta>>buscarContasPagas(){
	 var buscar = contaService.buscarPagas();
	 return new ResponseEntity<List<Conta>>(buscar,HttpStatus.OK);
	}
	
	@GetMapping("inadimplente")
	@Operation(summary = "Rota responsável pela busca de contas inadimplentes")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<Conta>>buscarInadimplente(){
		var busca = contaService.buscarInadimplentes();
		return new ResponseEntity<>(busca,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca da conta pelo id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<Conta>buscarPorId(@PathVariable Long id){
		var buscaId  = contaService.buscarPorId(id);
		return new ResponseEntity<>(buscaId,HttpStatus.OK);
	}
	
	@PutMapping
	@Operation(summary = "Rota responsável pela atualização de contas pagas")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<Conta>atualizarConta(@RequestBody @Valid Conta conta){
		var atualizar = contaService.atualizarConta(conta);
		return new ResponseEntity<>(atualizar,HttpStatus.OK);
	}
}
