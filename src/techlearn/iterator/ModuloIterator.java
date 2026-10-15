package techlearn.iterator;

import techlearn.composite.ComponenteCatalogo;
import java.util.List;

// Iterador concreto que sabe percorrer os itens de um Modulo
public class ModuloIterator implements Iterator<ComponenteCatalogo> {
    private List<ComponenteCatalogo> itens;
    private int posicao = 0;

    public ModuloIterator(List<ComponenteCatalogo> itens) {
        this.itens = itens;
    }

    @Override
    public boolean hasNext() {
        // Retorna true se a posição atual for menor que o total de itens
        return posicao < itens.size() && itens.get(posicao) != null;
    }

    @Override
    public ComponenteCatalogo next() {
        // Retorna o item atual e avança o cursor da posição
        ComponenteCatalogo item = itens.get(posicao);
        posicao++;
        return item;
    }
}
