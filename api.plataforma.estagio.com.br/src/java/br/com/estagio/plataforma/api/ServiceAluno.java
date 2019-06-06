/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOaluno;
import br.com.estagio.plataforma.fw.Cache;
import br.com.estagio.plataforma.to.TOaluno;
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

@Path("aluno")
public class ServiceAluno {
    
    @Context
    private HttpServletResponse response;

    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOaluno t) throws Exception {
        BOaluno.inserir(t);
        limpar();
    }
    

    @PUT
    @Consumes("application/json; charset=utf-8")
    public void alterar(TOaluno t) throws Exception {
        BOaluno.alterar(t);
        limpar();
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") int id) throws Exception {
        BOaluno.excluir(id);
        limpar();
    }
    
    
    @GET
    @Produces("application/json; charset=utf-8")
    public List<TOaluno> lista() throws Exception {

        Object o = Cache.getCache("aluno", "lista");

        if (o == null) {
            List<TOaluno> lista = BOaluno.lista();
            
            Cache.setCache("aluno", "lista", lista, 2);
            
            return lista;
        } else {
            return (List<TOaluno>) o;
        }
    }

    @GET
    @Path("limpar")
    @Produces("application/json; charset=utf-8")
    public void limpar() throws Exception {

        Cache.removeCache("aluno", "lista");
    }    
    
    
    @GET
    @Path("{id}")
    @Produces("application/json; charset=utf-8")
    public TOaluno obter(@PathParam("id") int id) throws Exception {
        TOaluno t = BOaluno.obter(id);
        
        if(t == null){
            response.sendError(404);
        }        
        return t;
    }

}
