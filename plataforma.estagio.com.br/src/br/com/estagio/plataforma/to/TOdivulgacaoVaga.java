
package br.com.estagio.plataforma.to;

import java.sql.Timestamp;

public class TOdivulgacaoVaga {
    private int vaga;
    private int faculdade;
    private int curso;
    
    private String descricao;
    private String local_atuacao;
    private String status;
    private float salario;
    private String horario;
    private int empresa;
    private String beneficios;
    private String cargo;
    private int qtdeVagas;
    private Timestamp inicioDivulgacao;
    
    private String nomeFaculdade;
    private String nomeCurso;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal_atuacao() {
        return local_atuacao;
    }

    public void setLocal_atuacao(String local_atuacao) {
        this.local_atuacao = local_atuacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getQtdeVagas() {
        return qtdeVagas;
    }

    public void setQtdeVagas(int qtdeVagas) {
        this.qtdeVagas = qtdeVagas;
    }

    public Timestamp getInicioDivulgacao() {
        return inicioDivulgacao;
    }

    public void setInicioDivulgacao(Timestamp inicioDivulgacao) {
        this.inicioDivulgacao = inicioDivulgacao;
    }

    public String getNomeFaculdade() {
        return nomeFaculdade;
    }

    public void setNomeFaculdade(String nomeFaculdade) {
        this.nomeFaculdade = nomeFaculdade;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getVaga() {
        return vaga;
    }

    public void setVaga(int vaga) {
        this.vaga = vaga;
    }

    public int getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(int faculdade) {
        this.faculdade = faculdade;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
