
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOaluno {
    public static void inserir(Connection c, TOaluno t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into aluno (nome_completo, matricula, dta_nascimento, cpf, telefone, email, faculdade, status, dta_conclusaoCurso, curso) values (?,?,?,?,?,?,?,?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getNome_completo(), t.getMatricula(), t.getDta_nascimento(),t.getCpf(),t.getTelefone(),t.getEmail(),t.getFaculdade(),t.getStatus(),t.getDta_conclusaoCurso(),t.getCurso());

    }
     
      public static void alterar(Connection c, TOaluno t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update aluno ");
        sql.append(" set nome_completo=?, matricula=?, dta_nascimento=?, cpf=?, telefone=?, email=?, faculdade=?, status=?, dta_conclusaoCurso=?, curso=? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), t.getNome_completo(), t.getMatricula(), t.getDta_nascimento(),t.getCpf(),t.getTelefone(),t.getEmail(),t.getFaculdade(),t.getStatus(),t.getDta_conclusaoCurso(),t.getCurso(), t.getId());

    }
      
      public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from aluno ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
      
      public static List<TOaluno> lista(Connection c) throws Exception {
        List<TOaluno> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome_completo, matricula, dta_nascimento, cpf, telefone, email, faculdade, status, dta_conclusaoCurso, curso from aluno ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            //O while pega registro a registro e cria uma instancia
            while (rs.next()) {
                TOaluno t = new TOaluno();
                t.setId(rs.getInt("id"));
                t.setNome_completo(rs.getString("nome_completo"));
                t.setMatricula(rs.getInt("matricula"));
                t.setDta_nascimento(rs.getTimestamp("dta_Nascimento"));
                t.setCpf(rs.getString("cpf"));
                t.setTelefone(rs.getString("telefone"));
                t.setEmail(rs.getString("email"));
                t.setFaculdadeAluno(rs.getInt("faculdade"));
                t.setStatus(rs.getString("status"));
                t.setDta_conclusaoCurso(rs.getTimestamp("dta_conclusaoCurso"));
                t.setCursoAluno(rs.getInt("curso"));

                lista.add(t);
            }

        }

        return lista;
    }
    

    public static TOaluno obter(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome_completo, matricula, dta_nascimento, cpf, telefone, email, faculdade, status, dta_conclusaoCurso, curso from aluno ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                TOaluno t = new TOaluno();
                t.setId(rs.getInt("id"));
                t.setNome_completo(rs.getString("nome_completo"));
                t.setMatricula(rs.getInt("matricula"));
                t.setDta_nascimento(rs.getTimestamp("dta_Nascimento"));
                t.setCpf(rs.getString("cpf"));
                t.setTelefone(rs.getString("telefone"));
                t.setEmail(rs.getString("email"));
                t.setFaculdadeAluno(rs.getInt("faculdade"));
                t.setStatus(rs.getString("status"));
                t.setDta_conclusaoCurso(rs.getTimestamp("dta_conclusaoCurso"));
                t.setCursoAluno(rs.getInt("CursoAluno"));
                return t;
            } else {
                return null;
            }

        }
    }    
}