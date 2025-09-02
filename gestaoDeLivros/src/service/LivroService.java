
/******************************************************************************
 * Nome do arquivo  : StationManager.java
 * Autor            : Leonidio Alves de Moraes Junior e Henrique Carvalho
 * Data de criação  : 01/09/2025
 * Empresa          : FATESG - Engenharia de Software - V Período
 * Descrição        : Gerenciador de Rede Radial
 *
 * Histórico de modificações:
 * Data        | Autor                          | Descrição
 * ------------|--------------------------------|--------------------------------
 * 01/09/2025  | Leonidio e Henrique | Implementação inicial
 *
 * Copyright (c) 2025 FATESG. Todos os direitos reservados.
 * Este código é confidencial e de propriedade de FATESG.
 * A sua distribuição ou reprodução é proibida sem autorização expressa.
 ******************************************************************************/

package service;

import entidade.Livro;
import repository.LivroRepository;

import java.util.List;
import java.util.Optional;

public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro cadastrarLivro(String titulo, String autor, String isbn, int anoPublicacao) {
        Livro novoLivro = new Livro(titulo, autor, isbn, anoPublicacao);

        Optional<Livro> existente = repository.buscarPorIsbn(isbn);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Já existe um livro com esse ISBN.");
        }

        return repository.salvar(novoLivro);
    }

    public List<Livro> listarLivros() {
        return repository.listarTodos();
    }

    public Optional<Livro> buscarLivroPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean atualizarLivro(int id, String novoTitulo, String novoAutor, int novoAno) {
        Optional<Livro> livroOpt = repository.buscarPorId(id);
        if (livroOpt.isEmpty()) {
            return false;
        }

        Livro livro = livroOpt.get();
        livro.setTitulo(novoTitulo);
        livro.setAutor(novoAutor);
        livro.setAnoPublicacao(novoAno);

        return repository.atualizar(livro);
    }

    public boolean removerLivro(int id) {
        return repository.deletar(id);
    }

    public boolean marcarComoIndisponivel(int id) {
        Optional<Livro> livroOpt = repository.buscarPorId(id);
        if (livroOpt.isEmpty()) {
            return false;
        }

        Livro livro = livroOpt.get();
        livro.setDisponivel(false);
        return repository.atualizar(livro);
    }

    public boolean marcarComoDisponivel(int id) {
        Optional<Livro> livroOpt = repository.buscarPorId(id);
        if (livroOpt.isEmpty()) {
            return false;
        }

        Livro livro = livroOpt.get();
        livro.setDisponivel(true);
        return repository.atualizar(livro);
    }

}
