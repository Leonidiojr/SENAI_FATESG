
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

package controller;

import entidade.Livro;
import service.LivroService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LivroController {
    private final LivroService service;
    private final Scanner scanner;

    public LivroController(LivroService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== SISTEMA DE GESTÃO DE LIVROS ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Todos os Livros");
            System.out.println("3. Buscar Livro por ID");
            System.out.println("4. Atualizar Livro");
            System.out.println("5. Marcar como Indisponível");
            System.out.println("6. Marcar como Disponível");
            System.out.println("7. Remover Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar buffer

                switch (opcao) {
                    case 1 -> cadastrarLivro();
                    case 2 -> listarLivros();
                    case 3 -> buscarLivroPorId();
                    case 4 -> atualizarLivro();
                    case 5 -> marcarIndisponivel();
                    case 6 -> marcarDisponivel();
                    case 7 -> removerLivro();
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine(); // limpar buffer
            }
        }
    }

    private void cadastrarLivro() {
        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("ISBN (formato XXX-X-XXXX-XXXX-X): ");
            String isbn = scanner.nextLine();

            System.out.print("Ano de publicação: ");
            int ano = scanner.nextInt();
            scanner.nextLine();

            Livro livro = service.cadastrarLivro(titulo, autor, isbn, ano);
            System.out.println("Livro cadastrado com sucesso: " + livro);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    private void listarLivros() {
        List<Livro> livros = service.listarLivros();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("\n--- Lista de Livros ---");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    private void buscarLivroPorId() {
        System.out.print("Digite o ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Livro> livro = service.buscarLivroPorId(id);
        if (livro.isPresent()) {
            System.out.println("Livro encontrado: " + livro.get());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void atualizarLivro() {
        System.out.print("ID do livro a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo título: ");
        String titulo = scanner.nextLine();

        System.out.print("Novo autor: ");
        String autor = scanner.nextLine();

        System.out.print("Novo ano de publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        boolean atualizado = service.atualizarLivro(id, titulo, autor, ano);
        if (atualizado) {
            System.out.println("Livro atualizado com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void marcarIndisponivel() {
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean sucesso = service.marcarComoIndisponivel(id);
        if (sucesso) {
            System.out.println("Livro marcado como indisponível.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void marcarDisponivel() {
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean sucesso = service.marcarComoDisponivel(id);
        if (sucesso) {
            System.out.println("Livro marcado como disponível.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void removerLivro() {
        System.out.print("ID do livro a remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tem certeza que deseja remover? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            boolean removido = service.removerLivro(id);
            if (removido) {
                System.out.println("Livro removido com sucesso.");
            } else {
                System.out.println("Livro não encontrado.");
            }
        } else {
            System.out.println("Remoção cancelada.");
        }
    }

}
