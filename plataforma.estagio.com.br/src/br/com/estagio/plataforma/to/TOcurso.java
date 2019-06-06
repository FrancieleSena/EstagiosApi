
package br.com.estagio.plataforma.to;

public class TOcurso {
   private int id; 
   private int faculdade; 
   private String nome; 
   private String duracao; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(int faculdade) {
        this.faculdade = faculdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
