
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOcurso {
    public static void inserir(Connection c, TOcurso t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into curso (nome,duracao,faculdade) values (?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getDuracao(),t.getFaculdade());

    }
     
      public static void alterar(Connection c, TOcurso t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update curso ");
        sql.append(" set nome=?,duracao=?,faculdade=? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getDuracao(),t.getFaculdade(), t.getId());

    }
      
      public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from curso ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
      
      public static List<TOcurso> lista(Connection c) throws Exception {
        List<TOcurso> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome,duracao,faculdade from curso ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            //O while pega registro a registro e cria uma instancia
            while (rs.next()) {
                TOcurso t = new TOcurso();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setDuracao(rs.getString("duracao"));
                t.setFaculdade(rs.getInt("faculdade"));

                lista.add(t);
            }

        }

        return lista;
    }

    public static TOcurso obter(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome,duracao,faculdade from curso ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) { 
                TOcurso t = new TOcurso();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setDuracao(rs.getString("duracao"));
                t.setFaculdade(rs.getInt("faculdade"));
                return t;
            } else {
                return null;
            }

        }
    }
}
