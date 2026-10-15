package techlearn;

import techlearn.composite.*;
import techlearn.iterator.Iterator;
import techlearn.logging.LoggerService;

public class Main {
    public static void main(String[] args) {
        LoggerService logger = LoggerService.getInstance();
        logger.log("Iniciando montagem da estrutura de cursos...");

        // Montando o curso raiz
        Modulo cursoEngenharia = new Modulo("Engenharia de Software Moderna");

        // Módulo 1
        Modulo moduloOO = new Modulo("Módulo 1: Orientação a Objetos Avançada");
        moduloOO.adicionar(new Aula("Aula 1.1: Coesão e Acoplamento", 45));
        moduloOO.adicionar(new Aula("Aula 1.2: Interfaces e Polimorfismo", 60));

        // Módulo 2
        Modulo moduloPadroes = new Modulo("Módulo 2: Padrões de Projeto (GoF)");
        moduloPadroes.adicionar(new Aula("Aula 2.1: Singleton na Prática", 30));
        moduloPadroes.adicionar(new Aula("Aula 2.2: Composite Hierárquico", 50));
        moduloPadroes.adicionar(new Aula("Aula 2.3: Iterator para Coleções", 40));

        // Montando a composição
        cursoEngenharia.adicionar(moduloOO);
        cursoEngenharia.adicionar(moduloPadroes);

        logger.log("Estrutura montada com sucesso. Exibindo detalhes da ementa:");
        cursoEngenharia.exibirDetalhes();

        System.out.println("\n==================================================");
        System.out.println(" Varredura do Curso Principal via Iterator:");
        System.out.println("==================================================");

        Iterator<ComponenteCatalogo> iterator = cursoEngenharia.criarIterator();
        while (iterator.hasNext()) {
            ComponenteCatalogo subItem = iterator.next();
            logger.log("Navegando no Item Raiz: " + subItem.getNome() + " | Duração acumulada: "
                    + subItem.getDuracaoMinutos() + " min");
        }

        // Desafio Passo 5
        System.out.println("\n==================================================");
        System.out.println(" [Passo 5] Aulas Curtas (Duração <= 45 minutos):");
        System.out.println("==================================================");
        filtrarAulasPorDuracaoMaxima(cursoEngenharia, 45);

        logger.log("Execução da atividade finalizada.");
    }

    /**
     * Método do Desafio: percorre a árvore via Iterator e filtra aulas curtas
     */
    public static void filtrarAulasPorDuracaoMaxima(ComponenteCatalogo componente, int duracaoMaxima) {
        Iterator<ComponenteCatalogo> it = componente.criarIterator();

        // Se o iterator tem itens (é um Módulo), navegamos recursivamente pelos filhos
        if (it.hasNext()) {
            while (it.hasNext()) {
                ComponenteCatalogo filho = it.next();
                filtrarAulasPorDuracaoMaxima(filho, duracaoMaxima);
            }
        } else {
            // Se o iterator não tem itens (é uma Folha / Aula)
            if (componente.getDuracaoMinutos() <= duracaoMaxima) {
                System.out.println("  ✓ [Aula Curta] " + componente.getNome() +
                        " (" + componente.getDuracaoMinutos() + " min)");
            }
        }
    }
}
