
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOvaga;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.TOvaga;
import java.sql.Connection;
import java.util.List;

public class BOvaga {

    public static void inserir(TOvaga t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOvaga.inserir(c, t);
        }
    }

    public static void alterar(TOvaga t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOvaga.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOvaga.excluir(c, id);
        }
    }

    public static TOvaga obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOvaga.obter(c, id);
        }
    }

    public static List<TOvaga> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOvaga.lista(c);
        }
    }

}
