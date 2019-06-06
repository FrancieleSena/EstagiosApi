
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOdivulgacaoVaga;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.TOdivulgacaoVaga;
import java.sql.Connection;
import java.util.List;

public class BOdivulgacaoVaga {
    public static void inserir(TOdivulgacaoVaga t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOdivulgacaoVaga.inserir(c, t);
        }
    }

    public static void excluirTodas(int vaga) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOdivulgacaoVaga.excluirTodas(c, vaga);
        }
    }
    
    public static void excluirVagaFaculdade(int vaga,int faculdade) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOdivulgacaoVaga.excluirVagaFaculdade(c, vaga,faculdade);
        }
    }
    public static void excluirVagaCurso(int vaga,int curso) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOdivulgacaoVaga.excluirVagaCurso(c, vaga,curso);
        }
    }

    public static List<TOdivulgacaoVaga> listaPorVaga(String vaga) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOdivulgacaoVaga.listaPorVaga(c,vaga);
        }
    }   

    public static List<TOdivulgacaoVaga> listaPorFaculdade(String faculdade) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOdivulgacaoVaga.listaPorFaculdade(c,faculdade);
        }
    }   
    
}
