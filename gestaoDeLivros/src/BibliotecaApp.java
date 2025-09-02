
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

import controller.LivroController;
import repository.LivroRepository;
import repository.LivroRepositoryMemoria;
import service.LivroService;

public class BibliotecaApp {
    public static void main(String[] args) {

        // Injeção de dependência manual
        LivroRepository repository = new LivroRepositoryMemoria();
        LivroService service = new LivroService(repository);
        LivroController controller = new LivroController(service);

        controller.executar();
    }
}