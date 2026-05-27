package com.designPattern.iterator.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Biblioteca implements FactoryIterableLivro, Iterable<Livro> {
    private ArrayList<Livro> livros = new ArrayList<>();

    public boolean cadastrarLivroBiblioteca(Livro... livros) {
        return this.livros.addAll(Arrays.asList(livros));
    }

    public boolean removeLivro(Livro livro) {
        return this.livros.remove(livro);
    }

    @Override
    public Iterator<Livro> iterator() {
        return livros.iterator();
    }

    @Override
    public Iterator<Livro> createIteratorLivrosDisponiveis() {
        return new LivroDisponivelIterator(livros);
    }

    @Override
    public Iterator<Livro> createIteratorLivrosPorAutor(String autor) {
        return new AutorLivroIterator(autor, livros);
    }
}
