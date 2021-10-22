package br.com.magnasistemas.cachacariaapi.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> escutaException(Exception e, WebRequest request){
		
		String descricaoMessage = e.getLocalizedMessage();
		String titutlo = e.getMessage();
		
		if(descricaoMessage == null) {
			
			descricaoMessage = e.toString();
		}
		
		ErroMessage erroMessage = new ErroMessage(new Date(), descricaoMessage);
		
		return new ResponseEntity<>(erroMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

// class para escutar as axceptions
//		return new ResponseEntity<>(e, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
