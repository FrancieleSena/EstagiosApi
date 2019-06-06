/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOcandidatos;
import br.com.estagio.plataforma.to.TOcandidatos;
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

@Path("candidatos")
public class ServiceCandidatos {
    
    @Context
    private HttpServletResponse response;

    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOcandidatos t) throws Exception {
        BOcandidatos.inserir(t);
    }
    

    @PUT
    @Consumes("application/json; charset=utf-8")
    public void alterar(TOcandidatos t) throws Exception {
        BOcandidatos.alterar(t);
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") int id) throws Exception {
        BOcandidatos.excluir(id);
    }
    
    @GET
    @Produces("application/json; charset=utf-8")
    public List<TOcandidatos> lista() throws Exception {
        return BOcandidatos.lista();
    }

    @GET
    @Path("{id}")
    @Produces("application/json; charset=utf-8")
    public TOcandidatos obter(@PathParam("id") int id) throws Exception {
        TOcandidatos t = BOcandidatos.obter(id);
        
        if(t == null){
            response.sendError(404);
        }
        
        return t;
    }

}
