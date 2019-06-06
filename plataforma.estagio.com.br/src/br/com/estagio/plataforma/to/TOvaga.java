
package br.com.estagio.plataforma.to;

import java.sql.Timestamp;

public class TOvaga {
   private int id;
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
    private String contato;   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}
