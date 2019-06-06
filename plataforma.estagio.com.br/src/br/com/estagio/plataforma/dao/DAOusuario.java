
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOusuario {
    
    public static TOusuario obterPorChave(Connection c, String chave) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, login, tipo, status, faculdade, empresa, senha, token, chave, expiracao from usuario ");
        sql.append(" where ");
        sql.append(" chave = ? ");
 
        try (ResultSet rs = Data.executeQuery(c, sql.toString(), chave)) {

            if (rs.next()) {

                TOusuario t = new TOusuario();
                
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setLogin(rs.getString("login"));
                t.setTipo(rs.getString("tipo"));
                t.setStatus(rs.getString("status"));
                t.setFaculdade(rs.getInt("faculdade"));
                t.setEmpresa(rs.getInt("empresa"));
                t.setSenha(rs.getString("senha"));
                t.setToken(rs.getString("token"));
                t.setToken(rs.getString("chave"));               
                t.setExpiracao(rs.getTimestamp("expiracao"));

                return t;

            } else {
                return null;
            }

        }

    }

    public static TOusuario autenticacao(Connection c, TOusuario u) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, token, chave, expiracao from usuario ");
        sql.append(" where ");
        sql.append(" login = ? ");
        sql.append(" and senha = sha1(?) "); // sha1 é uma função do mysql

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), u.getSenha())) {

            if (rs.next()) {

                TOusuario t = new TOusuario();    
                
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setToken(rs.getString("token"));
                t.setChave(rs.getString("chave"));
                t.setExpiracao(rs.getTimestamp("expiracao"));
                return t;

            } else {
                return null;
            }

        }

    }
    
    public static void setarToken(Connection c, TOusuario u) throws Exception {
        
        StringBuilder sql = new StringBuilder();
        sql.append(" update usuario set token = ?, expiracao = ? where id = ? ");
        
        Data.executeUpdate(c, sql.toString(), u.getToken(), u.getExpiracao(), u.getId());
        
    }
    
    public static void inserir(Connection c, TOusuario t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into usuario (nome, login, tipo, status, faculdade, empresa, senha, token, chave, expiracao ) values (?,?,?,?,?,?,sha1(?),?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getLogin(), t.getTipo(), t.getStatus(), t.getFaculdade(), t.getEmpresa(), t.getSenha(),t.getToken(),t.getChave(),t.getExpiracao());

    }
    
    public static void alterar(Connection c, TOusuario t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update usuario ");
        sql.append(" set nome=?, login=?, tipo=?, status=?, faculdade=?, empresa=?, senha=sha1(?), token=?, chave=?, expiracao=? ");
        sql.append(" where id=? ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getLogin(), t.getTipo(), t.getStatus(), t.getFaculdade(), t.getEmpresa(), t.getSenha(),t.getToken(),t.getChave(),t.getExpiracao(),t.getId());

    }
    
    public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from usuario");
        sql.append(" where id=?");

        Data.executeUpdate(c, sql.toString(), id);

    }
    
     public static List<TOusuario> lista(Connection c) throws Exception {
        List<TOusuario> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, login, tipo, status, faculdade, empresa, token, chave, expiracao from usuario ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                TOusuario t = new TOusuario();
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setLogin(rs.getString("login"));
                t.setTipo(rs.getString("tipo"));
                t.setStatus(rs.getString("status"));
                t.setFaculdade(rs.getInt("faculdade"));
                t.setEmpresa(rs.getInt("empresa"));
                t.setToken(rs.getString("token"));
                t.setToken(rs.getString("chave"));               
                t.setExpiracao(rs.getTimestamp("expiracao"));
                lista.add(t);
            }

        }

        return lista;
    }
    

    public static TOusuario obter(Connection c, String nome) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select nome ,login ,senha ,tipo,faculdade ,empresa ,status ,token,expiracao from usuario ");
        sql.append(" where nome = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), nome)) {

            if (rs.next()) {
                TOusuario t = new TOusuario();
                
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setLogin(rs.getString("login"));
                t.setTipo(rs.getString("tipo"));
                t.setStatus(rs.getString("status"));
                t.setFaculdade(rs.getInt("faculdade"));
                t.setEmpresa(rs.getInt("empresa"));
                t.setSenha(rs.getString("senha"));
                t.setToken(rs.getString("token"));
                t.setToken(rs.getString("chave"));               
                t.setExpiracao(rs.getTimestamp("expiracao"));
                
                return t;
                
            } else {
                return null;
            }

        }
    }   
    
}