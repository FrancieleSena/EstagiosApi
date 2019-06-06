
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOcurso;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.TOcurso;
import java.sql.Connection;
import java.util.List;

public class BOcurso {
    public static void inserir(TOcurso t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOcurso.inserir(c, t);
        }
    }

    public static void alterar(TOcurso t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOcurso.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOcurso.excluir(c, id);
        }
    }

    public static TOcurso obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOcurso.obter(c, id);
        }
    }

    public static List<TOcurso> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOcurso.lista(c);
        }
    }   
    
}
