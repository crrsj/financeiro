package com.financeiro.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


   @ControllerAdvice
   public class TratamentoDeErros {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>tratador400(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(TratandoErros::new).toList());		
	}
	public record TratandoErros(String campo,String mensagem) {
		public TratandoErros(FieldError erro) {
			this(erro.getField(),erro.getDefaultMessage());
		}

	}
}
