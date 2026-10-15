package techlearn.iterator;

// Implementação do padrão Null Object para o Iterator
// Uma aula (folha) não possui subelementos para iterar
public class NullIterator<T> implements Iterator<T> {

    @Override
    public boolean hasNext() {
        return false; // Sempre falso: não há itens para percorrer
    }

    @Override
    public T next() {
        return null;
    }
}
