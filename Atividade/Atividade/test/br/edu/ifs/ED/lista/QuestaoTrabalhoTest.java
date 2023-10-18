package br.edu.ifs.ED.lista;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuestaoTrabalhoTest extends ListaTest {

	public QuestaoTrabalhoTest(){
		super();
		lista = new ListaSimplesEncadeada<Integer>();
	}

	@Test
	public void QuestaoTransformarEmVetorTest() throws Exception { 
		int qtd = 5;
		Integer[] input = new Integer[qtd];
		for (Integer i = 0; i < qtd; i++) {
			lista.incluir(i);
			input[i] = i;
		}
		Integer[] vetor = lista.TransformarEmVetor();
		
		assertThat(lista.getTamanho()).isNotZero();
		assertThat(vetor.length).isEqualTo(qtd);
		assertArrayEquals(input, vetor);
	}	
	public void QuestaoTransformarEmVetorSemElementosTest() throws Exception {
		assertThat(lista.getTamanho()).isZero();
		Integer[] vetor = lista.TransformarEmVetor();
		assertThat(vetor.length).isEqualTo(0);
	}
	
	public void QuestaoTransformarEmVetorComElementosRemovidosTest() throws Exception {
		int qtd = 2;
		Integer[] input = new Integer[qtd];
		for (Integer i = 0; i < qtd; i++) {
			lista.incluir(i);
			input[i] = i;
		}
		lista.remover(0);
		lista.remover(0);
		Integer[] vetor = lista.TransformarEmVetor();
		assertThat(lista.getTamanho()).isZero();
		assertThat(vetor.length).isEqualTo(0);
	}

}


