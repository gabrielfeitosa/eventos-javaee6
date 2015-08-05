package com.gabrielfeitosa.business;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import com.gabrielfeitosa.evento.NovaCorEvento;

/**
 * @author gabrielf 29/07/2015
 */
@Stateless
public class NotificaClientesBusiness {

	public void notificarNovaCor(String novaCor) {
		System.out.printf("Já estou mandando as notificações para os clientes sobre a cor %s \n", novaCor);
	}
	
	@SuppressWarnings("unused")
	private void oOlhoQueVeTudo(@Observes NovaCorEvento evento){
		System.out.println("Acabei de receber o evento para notificar os clientes sobre a nova cor!");
		notificarNovaCor(evento.getNovaCor());
	}

}
