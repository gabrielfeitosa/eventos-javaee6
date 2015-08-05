package com.gabrielfeitosa.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.gabrielfeitosa.business.AtualizaCorDaParedeBusiness;
import com.gabrielfeitosa.business.NotificaClientesBusiness;
import com.gabrielfeitosa.business.PrecisoDeUmaTransacaoBusiness;
import com.gabrielfeitosa.evento.NovaCorEvento;

/**
 * @author gabrielf 29/07/2015
 */
@Stateless
public class Orquestrador {

	@EJB
	private AtualizaCorDaParedeBusiness atualizaCorDaParedeBusiness;
	@EJB
	private NotificaClientesBusiness notificaClientesBusiness;
	@EJB
	private PrecisoDeUmaTransacaoBusiness precisoDeUmaTransacaoBusiness;
	@Inject
	private Event<NovaCorEvento> event;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void fazAlgumaCoisaSemEventos(String novaCor) {
		atualizaCorDaParedeBusiness.atualizar(novaCor);
		notificaClientesBusiness.notificarNovaCor(novaCor);
		seTiverTransacaoQuebraTudo();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void fazAlgumaCoisaComEventos(String novaCor){
		NovaCorEvento evento = new NovaCorEvento(novaCor); 
		event.fire(evento);
	}
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void seTiverTransacaoQuebraTudo(){
		System.out.println("Oxem, tu fez cagada! Eu estou em uma transação e mesmo assim fui executado.");
		precisoDeUmaTransacaoBusiness.soFuncionoSeTiverUmaTransacao();
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void nemVenhaMudarACorQueEssaTaBoa(@Observes NovaCorEvento novaCor ){
		System.out.println("Eita cor feia, quero não!!!");
		precisoDeUmaTransacaoBusiness.soFuncionoSeTiverUmaTransacao();
	}
	
}
