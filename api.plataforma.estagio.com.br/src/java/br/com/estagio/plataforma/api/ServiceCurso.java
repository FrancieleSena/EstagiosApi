/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOcurso;
import br.com.estagio.plataforma.to.TOcurso;
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

@Path("curso")
public class ServiceCurso {
    
    @Context
    private HttpServletResponse response;

    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOcurso t) throws Exception {
        BOcurso.inserir(t);
    }
    

    @PUT
    @Consumes("application/json; charset=utf-8")
    public void alterar(TOcurso t) throws Exception {
        BOcurso.alterar(t);
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") int id) throws Exception {
        BOcurso.excluir(id);
    }
    
    @GET
    @Produces("application/json; charset=utf-8")
    public List<TOcurso> lista() throws Exception {
        return BOcurso.lista();
    }

    @GET
    @Path("{id}")
    @Produces("application/json; charset=utf-8")
    public TOcurso obter(@PathParam("id") int id) throws Exception {
        TOcurso t = BOcurso.obter(id);
        
        if(t == null){
            response.sendError(404);
        }
        
        return t;
    }

}
