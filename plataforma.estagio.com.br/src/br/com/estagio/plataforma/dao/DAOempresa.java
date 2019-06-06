
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.TOempresa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOempresa {
        public static void inserir(Connection c, TOempresa t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into empresa (nome, razao_social, cnpj, telefone, logradouro, uf, cidade, bairro, numero, status, area_atuacao, qtdeFuncionario) values (?,?,?,?,?,?,?,?,?,?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getRazao_social(), t.getCnpj(),t.getTelefone(),t.getLogradouro(),t.getUf(),t.getCidade(),t.getBairro(),t.getNumero(),t.getStatus(),t.getArea_atuacao(),t.getQtdeFuncionario());

    }
     
      public static void alterar(Connection c, TOempresa t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update empresa ");
        sql.append(" set nome=?, razao_social=?, cnpj=?, telefone=?, logradouro=?, uf=?, cidade=?, bairro=?, numero=?, status=?, area_atuacao=?, qtdeFuncionario=? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), t.getNome(), t.getRazao_social(), t.getCnpj(),t.getTelefone(),t.getLogradouro(),t.getUf(),t.getCidade(),t.getBairro(),t.getNumero(),t.getStatus(), t.getArea_atuacao(),t.getQtdeFuncionario(), t.getId());

    }
      
      public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from empresa ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
      
      public static List<TOempresa> lista(Connection c) throws Exception {
        List<TOempresa> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, razao_social, cnpj, telefone, logradouro, uf, cidade, bairro, numero, status, area_atuacao, qtdeFuncionario from empresa ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            //O while pega registro a registro e cria uma instancia
            while (rs.next()) {
                TOempresa t = new TOempresa();
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
                t.setArea_atuacao(rs.getString("area_atuacao"));
                t.setQtdeFuncionario(rs.getInt("qtdeFuncionario"));

                lista.add(t);
            }

        }

        return lista;
    }

    public static TOempresa obter(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nome, razao_social, cnpj, telefone, logradouro, uf, cidade, bairro, numero, status, area_atuacao, qtdeFuncionario from empresa ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                TOempresa t = new TOempresa();
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
                t.setArea_atuacao(rs.getString("area_atuacao"));
                t.setQtdeFuncionario(rs.getInt("qtdeFuncionario"));
                return t;
            } else {
                return null;
            }

        }
    }
}
