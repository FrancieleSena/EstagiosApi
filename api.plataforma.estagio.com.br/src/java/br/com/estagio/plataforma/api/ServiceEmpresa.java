/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOempresa;
import br.com.estagio.plataforma.to.TOempresa;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("empresa")
public class ServiceEmpresa {
    
    @Context
    private HttpServletResponse response;

    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOempresa t) throws Exception {
        BOempresa.inserir(t);
    }
    

    @PUT
    @Consumes("application/json; charset=utf-8")
    public void alterar(TOempresa t) throws Exception {
        BOempresa.alterar(t);
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") int id) throws Exception {
        BOempresa.excluir(id);
    }
    
    @GET
    @Produces("application/json; charset=utf-8")
    public List<TOempresa> lista() throws Exception {
        return BOempresa.lista();
    }

    @GET
    @Path("{id}")
    @Produces("application/json; charset=utf-8")
    public TOempresa obter(@PathParam("id") int id) throws Exception {
        TOempresa t = BOempresa.obter(id);
        
        if(t == null){
            response.sendError(404);
        }
        
        return t;
    }

}
