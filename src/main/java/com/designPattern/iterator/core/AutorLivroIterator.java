package com.designPattern.iterator.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AutorLivroIterator implements Iterator<Livro> {

    private int posicao;
    private ArrayList<Livro> livros;
    private String autor;

    public AutorLivroIterator(String autor, ArrayList<Livro> livros) {
        this.autor = autor;
        this.livros = livros;
    }

    @Override
    public boolean hasNext() {
        while (posicao < livros.size()) {
            if (livros.get(posicao).getAutor().equals(autor)) {
                return true;
            }
            posicao++;
        }
        return false;
    }

    @Override
    public Livro next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não existe livros do autor " + autor);
        }
        Livro livro = livros.get(posicao);
        posicao++;
        return livro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        posicao = 0;
    }
}
