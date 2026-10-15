package techlearn.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerService {
    // 1. A própria classe cria e guarda a sua ÚNICA instância (estática e final)
    private static final LoggerService INSTANCE = new LoggerService();

    // Formatador para a data e hora do log: "2026-10-15 16:00:00"
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 2. O SEGREDO DO SINGLETON: O construtor é PRIVADO!
    // Ninguém de fora consegue fazer "new LoggerService()"
    private LoggerService() {
        System.out.println("[SISTEMA] Serviço de Logging Inicializado.");
    }

    // 3. Ponto de acesso global: qualquer um chama LoggerService.getInstance()
    public static LoggerService getInstance() {
        return INSTANCE;
    }

    // Método comum para imprimir a mensagem formatada com data/hora
    public void log(String mensagem) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] [LOG]: " + mensagem);
    }
}
