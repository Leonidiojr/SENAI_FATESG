
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

package repository;

import entidade.Livro;

import java.util.*;

public class LivroRepositoryMemoria implements LivroRepository {
    private final Map<Integer, Livro> livros = new HashMap<>();

    @Override
    public Livro salvar(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo.");
        }
        livros.put(livro.getId(), livro);
        return livro;
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros.values());
    }

    @Override
    public Optional<Livro> buscarPorId(int id) {
        return Optional.ofNullable(livros.get(id));
    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        for (Livro livro : livros.values()) {
            if (livro.getIsbn().equals(isbn)) {
                return Optional.of(livro);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean atualizar(Livro livro) {
        if (livro == null || !livros.containsKey(livro.getId())) {
            return false;
        }
        livros.put(livro.getId(), livro);
        return true;
    }

    @Override
    public boolean deletar(int id) {
        if (!livros.containsKey(id)) {
            return false;
        }
        livros.remove(id);
        return true;
    }

    @Override
    public int contar() {
        return livros.size();
    }

}