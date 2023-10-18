package br.edu.ifs.ED.lista;

public abstract class Lista<T extends Comparable<T>> implements Comparable<Lista<T>> {
    /**
     * Adiciona um elemento no final da lista
     * @param elemento
     * @throws Exception
     */
    public abstract void incluir(T elemento) throws Exception;

    /**
     * Retorna o elemento que está na posição
     * @param posicao
     * @return
     * @throws Exception
     */
    public abstract T get(int posicao)  throws Exception;

    /**
     * Retorna a posição do elemento
     * @param elemento
     * @return
     * @throws Exception
     */
    public abstract int getPosElemento(T elemento)  throws Exception;

    /**
     * Remove o elemento da posição
     * @param posicao
     * @throws Exception
     */
    public abstract void remover(int posicao) throws Exception;

    /**
     * Remove todos os elementos da lista.
     * O(1)
     */
    public abstract void limpar();

    /**
     * Retorna a quantidade de elementos na lista
     * O(1)
     * @return
     */
    public abstract int getTamanho();

    /**
     * Indica se contém ou não o elemento na lista
     * O(n)
     * @param elemento
     * @return
     * @throws Exception
     */
    public abstract boolean contem(T elemento) throws Exception;


    /**
     * Compara uma lista com outra lista.
     * Caso os elementos estejam na mesma ordem deverá retornar 0, caso contrário deverá observar
     * a quantidade de elementos nas listas e retornar -1 se esta lista tiver menos elementos que a lista
     * passada como parâmetro e 1 caso a ela tenha mais elementos que a lista recebida como parâmetro.
     * @param item
     * @return
     */
    @Override
    public abstract int compareTo(Lista<T> item);



	//==========================
	public abstract T[] TransformarEmVetor();
}
