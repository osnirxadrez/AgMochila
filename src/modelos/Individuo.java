package modelos;

import java.util.ArrayList;
import java.util.Random;

public class Individuo {
   public int[] cromossomo;
   public int peso;
   public int valor;
   public int fitness;
   public double probabilidade;
   
   public void populaCromossomo(int qtItens) {
	   cromossomo = new int[qtItens];
	   for (int i=0; i<qtItens; i++) {
		   cromossomo[i] = sorteia();
	   }
   }
   
   public int sorteia() {
	   Random r = new Random();
	   return r.nextInt(2);
   }
  //verifica se  é mesmo cromossomo
   public boolean verificaClone(Individuo outro) {
	
	   for(int i=0; i<cromossomo.length; i++) {
		   if(cromossomo[i] != outro.cromossomo[i])
			   return false;
	   }
	   
	   return true;
   }
   
   public void calculaFitness(ArrayList<Item> itens, int capacidadeMochila) {
	   for(int i=0; i<cromossomo.length; i++) {
		   int gene = cromossomo[i];
		   if(gene == 1 ) {
			   peso += itens.get(i).peso;
			   valor += itens.get(i).valor;
			   
		   }
	   }
	   fitness = valor;
	   //penalidade fitness varia
	   if(peso > capacidadeMochila) {
		   fitness -= 700;
	   }
   }
   
   @Override
   public String toString() {
	   String ret = "";
	   for(int i : cromossomo) {
		   ret += i + "";
	   }
	   return ret + "- Fitness: "+ fitness+" peso: "+peso+" valor: "+valor+ " Probabilidade: "+probabilidade;
   }
   
}
