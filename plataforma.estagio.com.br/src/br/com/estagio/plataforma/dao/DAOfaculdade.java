
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.TOfaculdade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOfaculdade {
        public static void inserir(Connection c, TOfaculdade t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into faculdade (nome, razao_social, cnpj, telefone, logradouro, uf, cidade, bairro, numero, status) values (?,?,?,?,?,?,?,?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getRazao_social(), t.getCnpj(),t.getTelefone(),t.getLogradouro(),t.getUf(),t.getCidade(),t.getBairro(),t.getNumero(),t.getStatus());

    }
     
      public static void alterar(Connection c, TOfaculdade t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update faculdade ");
        sql.append(" set nome=?, razao_social=?, cnpj=?, telefone=?, logradouro=?, uf=?, cidade=?, bairro=?, numero=?, status=? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getRazao_social(), t.getCnpj(),t.getTelefone(),t.getLogradouro(),t.getUf(),t.getCidade(),t.getBairro(),t.getNumero(),t.getStatus(), t.getId());

    }
      
      public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from faculdade ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
      
      public static List<TOfaculdade> lista(Connection c) throws Exception {
        List<TOfaculdade> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, razao_social, cnpj, telefone, logradouro, uf, cidade, bairro, numero, status from faculdade ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            //O while pega registro a registro e cria uma instancia
            while (rs.next()) {
                TOfaculdade t = new TOfaculdade();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setRazao_social(rs.getString("razao_social"));
                t.setCnpj(rs.getString("cnpj"));
                t.setTelefone(rs.getString("telefone"));
                t.setLogradouro(rs.getString("logradouro"));
                t.setUf(rs.getString("uf"));
                t.setCidade(rs.getString("cidade"));
                t.setBairro(rs.getString("bairro"));
                t.setNumero(rs.getInt("numero"));
                t.setStatus(rs.getString("status"));

                lista.add(t);
            }

        }

        return lista;
    }

    public static TOfaculdade obter(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, razao_social, cnpj, telefone, logradouro, uf, cidade, bairro, numero, status from faculdade ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                TOfaculdade t = new TOfaculdade();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setRazao_social(rs.getString("razao_social"));
                t.setCnpj(rs.getString("cnpj"));
                t.setTelefone(rs.getString("telefone"));
                t.setLogradouro(rs.getString("logradouro"));
                t.setUf(rs.getString("uf"));
                t.setCidade(rs.getString("cidade"));
                t.setBairro(rs.getString("bairro"));
                t.setNumero(rs.getInt("numero"));
                t.setStatus(rs.getString("status"));
                return t;
            } else {
                return null;
            }

        }
    }
}
