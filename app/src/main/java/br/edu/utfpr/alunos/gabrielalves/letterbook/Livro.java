package br.edu.utfpr.alunos.gabrielalves.letterbook;

public class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacao;
    private int capa;

    public Livro(String titulo, String autor, String genero, int anoPublicacao, int capa) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getCapa() {
        return capa;
    }
}