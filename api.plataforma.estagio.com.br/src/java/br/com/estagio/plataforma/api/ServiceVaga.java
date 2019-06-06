/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOvaga;
import br.com.estagio.plataforma.fw.Cache;
import br.com.estagio.plataforma.to.TOvaga;
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

@Path("vaga")
public class ServiceVaga {
    
    @Context
    private HttpServletResponse response;

    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOvaga t) throws Exception {
        BOvaga.inserir(t);
        limpar();
    }
    

    @PUT
    @Consumes("application/json; charset=utf-8")
    public void alterar(TOvaga t) throws Exception {
        BOvaga.alterar(t);
        limpar();
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") int id) throws Exception {
        BOvaga.excluir(id);
        limpar();
    }
    
    
    @GET
    @Produces("application/json; charset=utf-8")
    public List<TOvaga> lista() throws Exception {

        Object o = Cache.getCache("vaga", "lista");

        if (o == null) {
            List<TOvaga> lista = BOvaga.lista();
            
            Cache.setCache("vaga", "lista", lista, 2);
            
            return lista;
        } else {
            return (List<TOvaga>) o;
        }
    }

    @GET
    @Path("limpar")
    @Produces("application/json; charset=utf-8")
    public void limpar() throws Exception {

        Cache.removeCache("vaga", "lista");
    }    
    
    
    @GET
    @Path("{id}")
    @Produces("application/json; charset=utf-8")
    public TOvaga obter(@PathParam("id") int id) throws Exception {
        TOvaga t = BOvaga.obter(id);
        
        if(t == null){
            response.sendError(404);
        }        
        return t;
    }

}
