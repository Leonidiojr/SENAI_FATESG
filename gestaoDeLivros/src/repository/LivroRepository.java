
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

import java.util.List;
import java.util.Optional;

public interface LivroRepository {
    Livro salvar(Livro livro);
    List<Livro> listarTodos();
    Optional<Livro> buscarPorId(int id);
    Optional<Livro> buscarPorIsbn(String isbn);
    boolean atualizar(Livro livro);
    boolean deletar(int id);
    int contar();
}
