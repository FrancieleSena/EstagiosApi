
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOfaculdade;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.util.List;


public class BOfaculdade {
    
    public static void inserir(TOfaculdade t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOfaculdade.inserir(c, t);
        }
    }

    public static void alterar(TOfaculdade t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOfaculdade.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOfaculdade.excluir(c, id);
        }
    }

    public static TOfaculdade obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOfaculdade.obter(c, id);
        }
    }

    public static List<TOfaculdade> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOfaculdade.lista(c);
        }
    }    

}