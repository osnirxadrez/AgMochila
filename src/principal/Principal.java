package principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelos.Individuo;
import modelos.Item;
import modelos.Pais;
import modelos.Populacao;
import modelos.Roleta;

public class Principal {
	
	static ArrayList<Item> itens = new ArrayList<Item>();
	static Populacao populacao = new Populacao();
	static int capacidadeMochila;
	static int qtPorGeracao;


	public static void main(String[] args) {
		//cadastraItens();		
		iniciaParaTestes();
	    //capacidadeMochila = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade da mochila"));
	   // qtPorGeracao = Integer.parseInt(JOptionPane.showInputDialog("Quantos Individuos por geração"));
	    criaPopulacao();
	    populacao.calculaProbabilidades();
	    
	    for (Individuo ind : populacao.individuos) {
	     	 System.out.println(ind);
    	 }
	    
	     Roleta roleta = new Roleta(populacao);	    
	     Pais pais = new Pais();
	     pais.populaListaPais(qtPorGeracao/2, roleta);
	     	     
	    
	     System.out.println("*****************************************");
	     for (Individuo ind : pais.individuos) {
			System.out.println(ind);
		}
	     
	     Populacao nova = pais.reproduz(itens.size());
	     nova.calculaFitness2(itens, capacidadeMochila);
	     nova.calculaProbabilidades();
	     
	     System.out.println("*****************************************");
	     for (Individuo ind : nova.individuos) {
	     	 System.out.println(ind);
    	 }
	 
	}
	
	static void iniciaParaTestes() {
		capacidadeMochila = 50;
		qtPorGeracao = 16;
		itens.add(new Item(100, 5));
		itens.add(new Item(50, 4));
		itens.add(new Item(300, 10));
		itens.add(new Item(20, 20));
		itens.add(new Item(30, 5));
		itens.add(new Item(45, 4));
		itens.add(new Item(100, 10));
		itens.add(new Item(40, 3));
		itens.add(new Item(10, 1));
		itens.add(new Item(20, 4));
		itens.add(new Item(30, 8));
		itens.add(new Item(40, 7));
		itens.add(new Item(50, 3));
		itens.add(new Item(60, 2));
	}
	
	static void cadastraItens() {
		int qtItens = Integer.parseInt(JOptionPane.showInputDialog("Informe a qt de itens"));
		for(int i=0; i<qtItens; i++) {
			itens.add(new Item());
		}
		
	}
	
	static void criaPopulacao() {
		populacao.montaPopulacao(qtPorGeracao, itens.size());
		populacao.calculaFitness2(itens, capacidadeMochila);
	}

}
