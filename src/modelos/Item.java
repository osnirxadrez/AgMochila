package modelos;

import javax.swing.JOptionPane;

public class Item {
 
   public int valor;
   public int peso;
   
   
   public Item() {
	   valor = Integer.parseInt(JOptionPane.showInputDialog("Valor"));
	   peso = Integer.parseInt(JOptionPane.showInputDialog("Peso"));
   }
   
   public Item(int valor, int peso) {
	  this.valor = valor;
	  this.peso = peso;
   }
   
   
}
