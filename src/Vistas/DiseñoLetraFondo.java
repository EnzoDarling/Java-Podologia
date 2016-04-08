package Vistas;

import javax.swing.JTextField;

public class DiseñoLetraFondo {
      String plomo= "#818181";
	  String negro= "#000000";
	  public void Mensaje(JTextField letra, String Mensaje, int tamaño){
	      if(tamaño == 0){
	          letra.setText(Mensaje);
	          letra.setForeground(java.awt.Color.decode(plomo));
	      }
	  }
	  public void Clic(JTextField letra, String Mensaje){
	    if(letra.getText().equals(Mensaje)){
	    letra.setText("");
	    letra.setForeground(java.awt.Color.decode(negro));
	    }
	  }
}
