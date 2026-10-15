package techlearn.composite;

import techlearn.iterator.Iterator;

public abstract class ComponenteCatalogo {

    // Por padrão, adicionar e remover lançam exceção.
    // Uma 'Aula' (folha) não tem filhos, então se alguém tentar adicionar nela,
    // receberá esse erro.
    public void adicionar(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operação não suportada neste nível.");
    }

    public void remover(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operação não suportada neste nível.");
    }

    public String getNome() {
        throw new UnsupportedOperationException();
    }

    public int getDuracaoMinutos() {
        throw new UnsupportedOperationException();
    }

    // Métodos abstratos: tanto a Aula quanto o Modulo são OBRIGADOS a implementar
    public abstract void exibirDetalhes();

    public abstract Iterator<ComponenteCatalogo> criarIterator();
}
