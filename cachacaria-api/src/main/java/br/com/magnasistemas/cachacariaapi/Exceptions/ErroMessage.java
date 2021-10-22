package br.com.magnasistemas.cachacariaapi.Exceptions;

import java.util.Date;

public class ErroMessage {
	private Date date;
	private String mensagem;
	
	public ErroMessage() {
		
	}
	
	public ErroMessage(Date date, String mensagem) {
		this.date = date;
		this.mensagem = mensagem;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
