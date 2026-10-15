package techlearn.iterator;

// Interface genérica que define como qualquer iterador do nosso sistema deve se comportar
public interface Iterator<T> {
    // Retorna true se ainda existem elementos a percorrer
    boolean hasNext();

    // Retorna o próximo elemento da coleção
    T next();
}
