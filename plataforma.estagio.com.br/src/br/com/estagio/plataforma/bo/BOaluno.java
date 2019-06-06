
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOaluno;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.TOaluno;
import java.sql.Connection;
import java.util.List;

public class BOaluno {

    public static void inserir(TOaluno t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOaluno.inserir(c, t);
        }
    }

    public static void alterar(TOaluno t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOaluno.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOaluno.excluir(c, id);
        }
    }

    public static TOaluno obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOaluno.obter(c, id);
        }
    }

    public static List<TOaluno> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOaluno.lista(c);
        }
    }

}
