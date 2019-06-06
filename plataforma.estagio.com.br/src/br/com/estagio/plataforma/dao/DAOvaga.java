
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOvaga {
    public static void inserir(Connection c, TOvaga t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into vaga (descricao, local_atuacao, status, salario, horario, empresa, beneficios, cargo, qtdeVagas, inicioDivulgacao, contato) values (?,?,?,?,?,?,?,?,?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getDescricao(), t.getLocal_atuacao(), t.getStatus(),t.getSalario(),t.getHorario(),t.getEmpresa(),t.getBeneficios(),t.getCargo(),t.getQtdeVagas(),t.getInicioDivulgacao(),t.getContato());

    }
     
      public static void alterar(Connection c, TOvaga t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" update vaga ");
        sql.append(" set descricao=?, local_atuacao=?, status=?, salario=?, horario=?, empresa=?, beneficios=?, cargo=?, qtdeVagas=?, inicioDivulgacao=?, contato=? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), t.getDescricao(), t.getLocal_atuacao(), t.getStatus(),t.getSalario(),t.getHorario(),t.getEmpresa(),t.getBeneficios(),t.getCargo(),t.getQtdeVagas(),t.getInicioDivulgacao(),t.getContato(), t.getId());

    }
      
      public static void excluir(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from vaga ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);

    }
      
      public static List<TOvaga> lista(Connection c) throws Exception {
        List<TOvaga> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, descricao, local_atuacao, status, salario, horario, empresa, beneficios, cargo, qtdeVagas, inicioDivulgacao, contato from vaga ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            //O while pega registro a registro e cria uma instancia
            while (rs.next()) {
                TOvaga t = new TOvaga();
                t.setId(rs.getInt("id"));
                t.setDescricao(rs.getString("descricao"));
                t.setLocal_atuacao(rs.getString("local_atuacao"));
                t.setStatus(rs.getString("status"));
                t.setSalario(rs.getFloat("salario"));
                t.setHorario(rs.getString("horario"));
                t.setEmpresa(rs.getInt("empresa"));
                t.setBeneficios(rs.getString("beneficios"));
                t.setCargo(rs.getString("cargo"));
                t.setQtdeVagas(rs.getInt("qtdeVagas"));
                t.setInicioDivulgacao(rs.getTimestamp("inicioDivulgacao"));
                t.setContato(rs.getString("contato"));

                lista.add(t);
            }

        }

        return lista;
    }
    

    public static TOvaga obter(Connection c, int id) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" select id, descricao, local_atuacao, status, salario, horario, empresa, beneficios, cargo, qtdeVagas, inicioDivulgacao, contato from vaga ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                TOvaga t = new TOvaga();
                t.setId(rs.getInt("id"));
                t.setDescricao(rs.getString("descricao"));
                t.setLocal_atuacao(rs.getString("local_atuacao"));
                t.setStatus(rs.getString("status"));
                t.setSalario(rs.getFloat("salario"));
                t.setHorario(rs.getString("horario"));
                t.setEmpresa(rs.getInt("empresa"));
                t.setBeneficios(rs.getString("beneficios"));
                t.setCargo(rs.getString("cargo"));
                t.setQtdeVagas(rs.getInt("qtdeVagas"));
                t.setInicioDivulgacao(rs.getTimestamp("inicioDivulgacao"));
                t.setContato(rs.getString("contato"));   
                
                return t;
                
            } else {
                return null;
            }

        }
    }    
}