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