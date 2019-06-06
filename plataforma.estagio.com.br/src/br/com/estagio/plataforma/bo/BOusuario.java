
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOusuario;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.fw.DateTime;
import br.com.estagio.plataforma.fw.Guid;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.util.List;

public class BOusuario {
    
public static TOusuario autenticacao(TOusuario u) throws Exception {

        try (Connection c = Data.openConnection()) {

            TOusuario t = DAOusuario.autenticacao(c, u);

            if (t != null) {

                String token = Guid.getString();

                DateTime date = DateTime.now();

                date.addHour(15);

                t.setExpiracao(date.getTimestamp());
                t.setToken(token);

                DAOusuario.setarToken(c, t);

            }

            return t;

        }

    }

public static void inserir(TOusuario t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOusuario.inserir(c, t);
        }
    }

    public static void alterar(TOusuario t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOusuario.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOusuario.excluir(c, id);
        }
    }

    public static TOusuario obter(String nome) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOusuario.obter(c, nome);
        }
    }

    public static List<TOusuario> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOusuario.lista(c);
        }
    }   
    
}