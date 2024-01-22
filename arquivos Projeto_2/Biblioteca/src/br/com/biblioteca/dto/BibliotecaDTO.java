package br.com.biblioteca.dto;

public class BibliotecaDTO {
    private int id_livro, isbn_livro, numpag_livro;
    private String nome_livro, editora_livro, autor_livro, genero_livro;

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    
    public int getIsbn_livro() {
        return isbn_livro;
    }

    public void setIsbn_livro(int isbn_livro) {
        this.isbn_livro = isbn_livro;
    }

    public int getNumpag_livro() {
        return numpag_livro;
    }

    public void setNumpag_livro(int numpag_livro) {
        this.numpag_livro = numpag_livro;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public String getEditora_livro() {
        return editora_livro;
    }

    public void setEditora_livro(String editora_livro) {
        this.editora_livro = editora_livro;
    }

    public String getAutor_livro() {
        return autor_livro;
    }

    public void setAutor_livro(String autor_livro) {
        this.autor_livro = autor_livro;
    }

    public String getGenero_livro() {
        return genero_livro;
    }

    public void setGenero_livro(String genero_livro) {
        this.genero_livro = genero_livro;
    }
    
}
