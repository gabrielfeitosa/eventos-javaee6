package com.gabrielfeitosa.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class TesteBean {

	@PostConstruct
	private void init(){
		System.out.println("Teste Bean ok!");
	}

	public String dizOla() {
		return "Olá...";
	}
}
