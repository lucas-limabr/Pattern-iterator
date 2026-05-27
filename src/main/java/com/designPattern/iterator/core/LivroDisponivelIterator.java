package com.designPattern.iterator.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LivroDisponivelIterator implements Iterator<Livro> {

    private int posicao = 0;
    private ArrayList<Livro> livros;

    public LivroDisponivelIterator(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean hasNext() {
        while (posicao < livros.size()) {
            if (livros.get(posicao).isDisponivel()) {
                return true;
            }
            posicao++;
        }
        return false;
    }

    @Override
    public Livro next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não existe livros disponíveis");
        }
        Livro livro = livros.get(posicao);
        posicao++;
        return livro;
    }
}
