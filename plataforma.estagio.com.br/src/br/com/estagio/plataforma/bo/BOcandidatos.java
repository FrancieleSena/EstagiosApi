
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOcandidatos;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.util.List;


public class BOcandidatos {
    
    public static void inserir(TOcandidatos t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOcandidatos.inserir(c, t);
        }
    }

    public static void alterar(TOcandidatos t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOcandidatos.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOcandidatos.excluir(c, id);
        }
    }

    public static TOcandidatos obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOcandidatos.obter(c, id);
        }
    }

    public static List<TOcandidatos> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOcandidatos.lista(c);
        }
    }    

}