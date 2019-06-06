
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOcandidatos {
  public static void inserir(Connection c, TOcandidatos t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into candidatos (vaga, aluno) values (?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getVaga(), t.getAluno());

    }
     
      public static void alterar(Connection c, TOcandidatos t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update candidatos ");
        sql.append(" set vaga=?, aluno=? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), t.getVaga(),t.getAluno(), t.getId());

    }
      
      public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from candidatos ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
      
      public static List<TOcandidatos> lista(Connection c) throws Exception {
        List<TOcandidatos> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, vaga, aluno from candidatos ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            //O while pega registro a registro e cria uma instancia
            while (rs.next()) {
                TOcandidatos t = new TOcandidatos();
                t.setId(rs.getInt("id"));
                t.setVaga(rs.getInt("vaga"));
                t.setAluno(rs.getInt("aluno"));

                lista.add(t);
            }

        }

        return lista;
    }

    public static TOcandidatos obter(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, vaga, aluno from candidatos ");
        sql.append(" where vaga = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                TOcandidatos t = new TOcandidatos();
                t.setId(rs.getInt("id"));
                t.setVaga(rs.getInt("vaga"));
                t.setAluno(rs.getInt("aluno"));
                return t;
            } else {
                return null;
            }

        }
    }  
}
