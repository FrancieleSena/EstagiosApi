
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOusuario;
import br.com.estagio.plataforma.to.TOusuario;
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

@Path("usuario")
public class ServiceUsuario {
    
    @Context
    private HttpServletResponse response;
    
    @POST
    @Path("autenticacao")
    @Produces("application/json; charset=utf-8")
    @Consumes("application/json; charset=utf-8")
    
    public TOusuario autenticacao(TOusuario u) throws Exception {
        return BOusuario.autenticacao(u);
    }
    
    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOusuario t) throws Exception {
        BOusuario.inserir(t);
    }    

    @PUT
    @Consumes("application/json; charset=utf-8")
    public void alterar(TOusuario t) throws Exception {
        BOusuario.alterar(t);
    }

    @DELETE
    @Path("{id}")
    public void excluir(@PathParam("id") int id) throws Exception {
        BOusuario.excluir(id);
    }
    
    @GET
    @Produces("application/json; charset=utf-8")
    public List<TOusuario> lista() throws Exception {
        return BOusuario.lista();
    }

    @GET
    @Path("{nome}")
    @Produces("application/json; charset=utf-8")
    public TOusuario obter(@PathParam("nome") String nome) throws Exception {
        TOusuario t = BOusuario.obter(nome);
        
        if(t == null){
            response.sendError(404);
        }
        
        return t;
    }
    
}
