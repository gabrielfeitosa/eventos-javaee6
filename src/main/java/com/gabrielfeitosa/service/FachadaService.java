package com.gabrielfeitosa.service;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * 
 * @author gabrielf 30/07/2015
 *
 */
@Path("/fachada")
public class FachadaService {

	@EJB
	private Orquestrador orquestrador;
	
	@GET
	@Path("/sem/{cor}")
	public Response fazAlgumaCoisaSemEventos(@PathParam("cor")String novaCor) {
		orquestrador.fazAlgumaCoisaSemEventos(novaCor);
		String resposta = "Executado em "+Calendar.getInstance().getTime();
		return Response.ok().entity(resposta).build();
	}
	
	@GET
	@Path("/com/{cor}")
	public Response fazAlgumaCoisaComEventos(@PathParam("cor")String novaCor) {
		orquestrador.fazAlgumaCoisaComEventos(novaCor);
		String resposta = "Executado em"+Calendar.getInstance().getTime();
		return Response.ok().entity(resposta).build();
	}
}