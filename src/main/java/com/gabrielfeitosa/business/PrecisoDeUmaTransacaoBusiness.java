package com.gabrielfeitosa.business;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author gabrielf 29/07/2015
 */
@Stateless
public class PrecisoDeUmaTransacaoBusiness {

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void soFuncionoSeTiverUmaTransacao(){
		System.out.println("Opa, tu tem a transa��o que eu preciso.");
	}
}
