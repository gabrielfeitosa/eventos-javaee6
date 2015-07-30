package com.gabrielfeitosa.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.gabrielfeitosa.bean.TesteBean;

@Path("/teste")
public class TesteService {

	@Inject
	private TesteBean testeBean;
	
	@GET
	public Response ola(){
		return Response.ok().entity(testeBean.dizOla()).build();
	}
}
