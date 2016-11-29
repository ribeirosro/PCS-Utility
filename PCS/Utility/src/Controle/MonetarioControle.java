package Controle;

import App.Monetario;
import Classes.ArquivoXML;
import Classes.Monny;
import javax.swing.JLabel;



public class MonetarioControle {
    ArquivoXML<Monny> arquivoXML = new ArquivoXML<>("monetario.XML");
    private double valor;
    
    public MonetarioControle(){
        valor = 0;
        arquivoXML.leXML();
    }
    
    public void mostrarSaldo(JLabel saldo){
        saldo.setText("Seu saldo é de R$ " + this.valor);
    }
    
    public void Voltar(Monetario monetario){
        monetario.dispose();
    }
}
