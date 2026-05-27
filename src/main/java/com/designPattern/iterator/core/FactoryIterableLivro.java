package com.designPattern.iterator.core;

import java.util.Iterator;

public interface FactoryIterableLivro {
    Iterator<Livro> createIteratorLivrosDisponiveis();
    Iterator<Livro> createIteratorLivrosPorAutor(String autor);
}
