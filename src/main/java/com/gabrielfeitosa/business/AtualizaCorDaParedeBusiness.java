package com.gabrielfeitosa.business;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import com.gabrielfeitosa.evento.NovaCorEvento;

/**
 * @author gabrielf 29/07/2015
 */
@Stateless
public class AtualizaCorDaParedeBusiness {

	public void atualizar(String novaCor) {
		System.out.printf("Já estou mudando a cor da parede para %s \n", novaCor);
	}
	
	@SuppressWarnings("unused")
	private void oOlhoQueTudoVe(@Observes NovaCorEvento evento){
		System.out.println("Acabei de receber o evento para atualizar a cor da parede!");
		atualizar(evento.getNovaCor());
	}
}
