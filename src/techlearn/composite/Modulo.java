package techlearn.composite;

import techlearn.iterator.Iterator;
import techlearn.iterator.ModuloIterator;
import techlearn.logging.LoggerService;

import java.util.ArrayList;
import java.util.List;

// Modulo representa o nó Composto (Composite) da árvore: pode conter Aulas ou outros Módulos
public class Modulo extends ComponenteCatalogo {
    private String nome;
    private List<ComponenteCatalogo> subComponentes = new ArrayList<>();

    public Modulo(String nome) {
        this.nome = nome;
    }

    @Override
    public void adicionar(ComponenteCatalogo componente) {
        subComponentes.add(componente);
        // Integração com o Singleton de Log
        LoggerService.getInstance().log("Item '" +
                componente.getNome() + "' adicionado ao módulo '" + this.nome + "'.");
    }

    @Override
    public void remover(ComponenteCatalogo componente) {
        subComponentes.remove(componente);
        // Integração com o Singleton de Log
        LoggerService.getInstance().log("Item '" +
                componente.getNome() + "' removido do módulo '" + this.nome + "'.");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDuracaoMinutos() {
        // Cálculo uniforme e recursivo: soma os minutos de todos os componentes filhos
        int total = 0;
        for (ComponenteCatalogo c : subComponentes) {
            total += c.getDuracaoMinutos();
        }
        return total;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n[Módulo/Curso]: " + getNome() + " | Duração Total: " + getDuracaoMinutos() + " min");
        System.out.println("--------------------------------------------------");
        for (ComponenteCatalogo c : subComponentes) {
            c.exibirDetalhes();
        }
    }

    public List<ComponenteCatalogo> getSubComponentes() {
        return subComponentes;
    }

    @Override
    public Iterator<ComponenteCatalogo> criarIterator() {
        // Retorna o iterador concreto que sabe percorrer a lista interna
        return new ModuloIterator(subComponentes);
    }
}
