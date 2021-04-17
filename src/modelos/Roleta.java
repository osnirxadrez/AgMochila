package modelos;

import java.util.ArrayList;
import java.util.Random;

public class Roleta {
 	 
	   Populacao populacao;
	   ArrayList<Double> posicoes = new ArrayList<Double>();
	   
	   public Roleta(Populacao p) {
		   populacao = p;
		   criaRoleta();
	   }
	   
	   public void criaRoleta() {
		   int somaProb = populacao.somaProbabilidadePopulacao();
		   int qt = 0;
		   for(Individuo ind : populacao.individuos) {
			   double posInd = ind.probabilidade;
			   if(qt==0)
				   posicoes.add(posInd);
			   else {
				   posicoes.add(posicoes.get(qt-1) + posInd);
			   }
				   qt++;
		   }
		   
	   }
	   
	   public Individuo sorteia() {
		   Random r = new Random();
		   String nr = posicoes.get(posicoes.size()-1)+"";
		   nr = nr.substring(0,nr.indexOf("."));
		   int nrSorteado= r.nextInt(Integer.parseInt(nr)) ;
		   
		   int qt = 0;
		   while(posicoes.get(qt)<nrSorteado) {
			   qt++;
		   }
		   return populacao.individuos.get(qt>0?qt-1:qt);
	   }
	   
	   
	   
}
