package com.designPattern.iterator.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LivroDisponivelIteratorTest {

    Livro livro1;
    Livro livro2;
    Livro livro3;
    Biblioteca biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    void deveCriarIteradorParaIterarLivroDisponivel() {
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosDisponiveis();
        assertInstanceOf(LivroDisponivelIterator.class, iterator);
    }

    @Test
    void deveRetornarTrueTemProximoLivroDisponivelAoIterarACollection() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Clean Architeture", "Robert C. Martin", true);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosDisponiveis();
        assertTrue(iterator.hasNext());
    }

    @Test
    void deveRetornarFalseTemProximoLivroDisponivelAoIterarACollection() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Clean Architeture", "Robert C. Martin", false);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosDisponiveis();
        assertFalse(iterator.hasNext());
    }

    @Test
    void deveRetornarOLivroDisponivelAoIterarACollection() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Clean Architecture", "Robert C. Martin", false);
        livro3 = new Livro("Design Patterns", "Erich Gamma", true);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2, livro3);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosDisponiveis();
        if (iterator.hasNext()) {
            assertEquals(livro3, iterator.next());
        }
    }

    @Test
    void deveLancarExcecaoAoChamarMetodoNextSemHasNextQuandoNaoTemLivroDisponivel() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Clean Architecture", "Robert C. Martin", false);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosDisponiveis();

        NoSuchElementException e = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("Não existe livros disponíveis", e.getMessage());
    }
}