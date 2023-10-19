package br.edu.ifs.ED.lista;

public class ListaSimplesEncadeada<T extends Comparable<T>> extends Lista<T> {
    private No<T> primeiro;

    public ListaSimplesEncadeada() {
        primeiro = null;
    }

    @Override
    public void incluir(T elemento) {
        No<T> novoNo = new No<>();
        novoNo.dado = elemento;
        novoNo.proximo = primeiro;
        primeiro = novoNo;
    }

    @Override
    public T get(int posicao) throws Exception {
        if (posicao < 0 || posicao >= getTamanho()) {
            throw new IndexOutOfBoundsException("Posição solicitada não existe na lista");
        }
        No<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }


    @Override
    public int getPosElemento(T elemento) throws Exception {
        No<T> atual = primeiro;
        int posicao = 0;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return posicao;
            }
            atual = atual.proximo;
            posicao++;
        }
        return -1;
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= getTamanho()) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            primeiro = primeiro.proximo;
        } else {
            No<T> anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.proximo;
            }
            anterior.proximo = anterior.proximo.proximo;
        }
    }

    @Override
    public void limpar() {
        primeiro = null;
    }

    @Override
    public int getTamanho() {
        int tamanho = 0;
        No<T> atual = primeiro;
        while (atual != null) {
            atual = atual.proximo;
            tamanho++;
        }
        return tamanho;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        return getPosElemento(elemento) != -1;
    }

    @Override
    public int compareTo(Lista<T> item) {
        int tamanhoThis = this.getTamanho();
        int tamanhoItem = item.getTamanho();

        if (tamanhoThis < tamanhoItem) {
            return -1;
        } else if (tamanhoThis > tamanhoItem) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public T[] TransformarEmVetor() {
        int tamanho = getTamanho();
        Integer[] vetor = new Integer[tamanho];

        transformarEmVetorRecursivo(primeiro, vetor, 0);
        return (T[]) vetor;
    }

    private void transformarEmVetorRecursivo(No<T> no, Integer[] vetor, int indice) {
        if (no == null) {
            return;
        }

        vetor[indice] = (Integer) no.dado;
        transformarEmVetorRecursivo(no.proximo, vetor, indice + 1);
    }
}
