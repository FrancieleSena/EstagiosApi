
package br.com.estagio.plataforma.to;

import java.sql.Timestamp;

public class TOaluno {
    private int id;
    private String nome_completo;
    private int matricula;
    private Timestamp dta_nascimento;
    private String cpf;
    private String telefone;
    private String email;
    private int faculdade;
    private String status;
    private Timestamp dta_conclusaoCurso;
    private int curso;

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Timestamp getDta_nascimento() {
        return dta_nascimento;
    }

    public void setDta_nascimento(Timestamp dta_nascimento) {
        this.dta_nascimento = dta_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDta_conclusaoCurso() {
        return dta_conclusaoCurso;
    }

    public void setDta_conclusaoCurso(Timestamp dta_conclusaoCurso) {
        this.dta_conclusaoCurso = dta_conclusaoCurso;
    }

    public int getFaculdade() {
        return faculdade;
    }

    public void setFaculdadeAluno(int faculdadeAluno) {
        this.faculdade = faculdadeAluno;
    }

    public int getCurso() {
        return curso;
    }

    public void setCursoAluno(int curso) {
        this.curso = curso;
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
