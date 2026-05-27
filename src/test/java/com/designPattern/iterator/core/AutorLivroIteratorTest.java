package com.designPattern.iterator.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class AutorLivroIteratorTest {

    Livro livro1;
    Livro livro2;
    Livro livro3;
    Biblioteca biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    void deveCriarIteradorParaIterarLivroPorAutor() {
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosPorAutor("Robert C. Martin");
        assertInstanceOf(AutorLivroIterator.class, iterator);
    }

    @Test
    void deveRetornarTrueTemProximoLivroPorAutorAoIterarACollection() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Design Patterns", "Erich Gamma", true);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosPorAutor("Robert C. Martin");
        assertTrue(iterator.hasNext());
    }

    @Test
    void deveRetornarFalseTemProximoLivroPorAutorAoIterarACollection() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Design Patterns", "Erich Gamma", true);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosPorAutor("Gustavo Guanabara");
        assertFalse(iterator.hasNext());
    }

    @Test
    void deveRetornarOLivroPorAutorAoIterarACollection() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", true);
        livro2 = new Livro("Clean Architecture", "Robert C. Martin", false);
        livro3 = new Livro("Design Patterns", "Erich Gamma", false);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2, livro3);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosPorAutor("Erich Gamma");
        if (iterator.hasNext()) {
            assertEquals(livro3, iterator.next());
        }
    }

    @Test
    void deveRetornarTrueTemProximoLivroAposAlterarAutorDoIterator() {
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Design Patterns", "Erich Gamma", true);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        AutorLivroIterator iterator = (AutorLivroIterator) biblioteca.createIteratorLivrosPorAutor("Gustavo Guanabara");
        assertFalse(iterator.hasNext());
        iterator.setAutor("Robert C. Martin");
        assertTrue(iterator.hasNext());
    }

    @Test
    void deveLancarExcecaoAoChamarMetodoNextSemHasNextQuandoNaoTemLivroPorAutor() {
        String autor = "Gustavo Guanabara";
        livro1 = new Livro("Clean Code", "Robert C. Martin", false);
        livro2 = new Livro("Clean Architecture", "Robert C. Martin", false);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2);
        Iterator<Livro> iterator = biblioteca.createIteratorLivrosPorAutor(autor);

        NoSuchElementException e = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("Não existe livros do autor " + autor, e.getMessage());
    }
}