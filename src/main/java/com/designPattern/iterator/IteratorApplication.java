package com.designPattern.iterator;

import com.designPattern.iterator.core.Biblioteca;
import com.designPattern.iterator.core.Livro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IteratorApplication {


    public static void main(String[] args) {

        //SpringApplication.run(IteratorApplication.class, args);

        Livro livro1;
        Livro livro2;
        Livro livro3;
        Biblioteca biblioteca = new Biblioteca();

        livro1 = new Livro("Clean Code", "Robert C. Martin", true);
        livro2 = new Livro("Clean Architecture", "Robert C. Martin", false);
        livro3 = new Livro("Design Patterns", "Erich Gamma", false);
        biblioteca.cadastrarLivroBiblioteca(livro1, livro2, livro3);

        for (Livro livro : biblioteca) {
            System.out.println("Título do livro: " + livro.getTitulo());
        }
    }
}
