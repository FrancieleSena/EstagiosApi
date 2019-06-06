
package br.com.estagio.plataforma.to;

import java.sql.Timestamp;

public class TOusuario {
    private int id;
    private String nome;
    private String login;
    private String tipo;
    private String status;
    private int faculdade;
    private int empresa;
    private String senha;
    private String token;
    private String chave;
    private Timestamp expiracao;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(int faculdade) {
        this.faculdade = faculdade;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Timestamp getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(Timestamp expiracao) {
        this.expiracao = expiracao;
    }

}