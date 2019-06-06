
package br.com.estagio.plataforma.dao;

import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOdivulgacaoVaga {
    public static void inserir(Connection c, TOdivulgacaoVaga t) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" insert into divulgacaoVaga (vaga,faculdade,curso) values (?,?,?) ");

        Data.executeUpdate(c, sql.toString(), t.getVaga(), t.getFaculdade(),t.getCurso());

    }
      
      public static void excluirTodas(Connection c, int vaga) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from divulgacaoVaga ");
        sql.append(" where vaga = ? ");

        Data.executeUpdate(c, sql.toString(), vaga);

    }
      public static void excluirVagaFaculdade(Connection c, int vaga,int faculdade) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from divulgacaoVaga ");
        sql.append(" where vaga = ? and faculdade=? ");

        Data.executeUpdate(c, sql.toString(), vaga,faculdade);

    }
      public static void excluirVagaCurso(Connection c, int vaga,int curso) throws Exception {

        StringBuilder sql = new StringBuilder();
        sql.append(" delete from divulgacaoVaga ");
        sql.append(" where vaga = ? and curso=? ");

        Data.executeUpdate(c, sql.toString(), vaga,curso);

    }
      
      public static List<TOdivulgacaoVaga> listaPorVaga(Connection c, String vaga) throws Exception {
        List<TOdivulgacaoVaga> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select vaga.*,faculdade.nome nomeFaculdade,curso.nome nomeCurso from divulgacaoVaga dv ");
        sql.append(" left outer join faculdade f (f.id=dv.faculdade) ");
        sql.append(" left outer join curso c (c.id=dv.curso) ");
        sql.append(" left outer join vaga v (v.id=dv.vaga) ");
        sql.append(" where dv.vaga=? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), vaga)) {
            while (rs.next()) {
                TOdivulgacaoVaga t = new TOdivulgacaoVaga();
                t.setVaga(rs.getInt("vaga"));
                t.setFaculdade(rs.getInt("faculdade"));
                t.setCurso(rs.getInt("curso"));
                t.setNomeFaculdade(rs.getString("nomeFaculdade"));
                t.setNomeCurso(rs.getString("nomeCurso"));
                t.setDescricao(rs.getString("descricao"));
                t.setBeneficios(rs.getString("beneficios"));
                t.setHorario(rs.getString("horario"));
                t.setInicioDivulgacao(rs.getTimestamp("horario"));
                t.setLocal_atuacao(rs.getString("local_atuacao"));
                t.setSalario(rs.getFloat("salario"));

                lista.add(t);
            }

        }

        return lista;
    }
      public static List<TOdivulgacaoVaga> listaPorFaculdade(Connection c, String faculdade) throws Exception {
        List<TOdivulgacaoVaga> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select vaga.*,faculdade.nome nomeFaculdade,curso.nome nomeCurso from divulgacaoVaga dv ");
        sql.append(" left outer join faculdade f (f.id=dv.faculdade) ");
        sql.append(" left outer join curso c (c.id=dv.curso) ");
        sql.append(" left outer join vaga v (v.id=dv.vaga) ");
        sql.append(" where dv.faculdade=? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), faculdade)) {
            while (rs.next()) {
                TOdivulgacaoVaga t = new TOdivulgacaoVaga();
                t.setVaga(rs.getInt("vaga"));
                t.setFaculdade(rs.getInt("faculdade"));
                t.setCurso(rs.getInt("curso"));
                t.setNomeFaculdade(rs.getString("nomeFaculdade"));
                t.setNomeCurso(rs.getString("nomeCurso"));
                t.setDescricao(rs.getString("descricao"));
                t.setBeneficios(rs.getString("beneficios"));
                t.setHorario(rs.getString("horario"));
                t.setInicioDivulgacao(rs.getTimestamp("horario"));
                t.setLocal_atuacao(rs.getString("local_atuacao"));
                t.setSalario(rs.getFloat("salario"));

                lista.add(t);
            }

        }

        return lista;
    }
    
}
