
package br.com.estagio.plataforma.api;

import br.com.estagio.plataforma.bo.BOdivulgacaoVaga;
import br.com.estagio.plataforma.to.TOdivulgacaoVaga;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("divulgacaoVaga")
public class ServiceDivulgacaoVaga {

    @POST
    @Consumes("application/json; charset=utf-8")
    public void inserir(TOdivulgacaoVaga t) throws Exception {
        BOdivulgacaoVaga.inserir(t);
    }

    @DELETE
    @Path("{vaga}")
    public void excluirTodas(@PathParam("vaga") int vaga) throws Exception {
        BOdivulgacaoVaga.excluirTodas(vaga);
    }

    @DELETE
    @Path("{vaga}{faculdade}")
    public void excluirVagaFaculdade(@PathParam("vaga") int vaga,@PathParam("faculdade") int faculdade) throws Exception {
        BOdivulgacaoVaga.excluirVagaFaculdade(vaga,faculdade);
    }

    @DELETE
    @Path("{vaga}{curso}")
    public void excluirVagaCurso(@PathParam("vaga") int vaga,@PathParam("curso") int curso) throws Exception {
        BOdivulgacaoVaga.excluirVagaCurso(vaga,curso);
    }   
 
    
}