
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOusuario;
import br.com.estagio.plataforma.fw.Criptografia;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.fw.DateTime;
import br.com.estagio.plataforma.to.TOusuario;
import java.sql.Connection;

public class BOautenticacao {

    private static final String CHAVE_PRIVADA = "COTEMIG2018";

    public static boolean autentica(String chave, String token) throws Exception {

         try (Connection c = Data.openConnection()) {

            TOusuario t = DAOusuario.obterPorChave(c, chave);

            if (t != null) {
                
                DateTime agora = DateTime.now();

                if (token != null && 
                        token.equals(Criptografia.sha1(t.getToken() + CHAVE_PRIVADA)) &&
                        t.getExpiracao().after(agora.getTimestamp())) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        }

    }

}
