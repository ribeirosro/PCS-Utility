package Controle;

import Classes.ArquivoXML;
import App.Notas;

import Classes.BlocoDeNotas;
import Classes.Sessao;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.JTextField;

public class NotasControle {
    ArquivoXML<BlocoDeNotas> arquivoXML = new ArquivoXML<>("notas.XML");
    
    public NotasControle(){
        arquivoXML.leXML();
    }
    
    public void Visualizar(JList lista){
        arquivoXML.leXML();
        
        DefaultListModel dlm = new DefaultListModel();
        
        ArrayList<BlocoDeNotas> arquivoNotas = arquivoXML.getLista();
        
        for (BlocoDeNotas notas : arquivoNotas){
            if(notas.getUsuario().equals(Sessao.getUsuario()))
                dlm.addElement(notas.getNota());
                
        }
        lista.setModel(dlm);
    }
    
    public void Inserir(String anotacao){
        if (!EmBranco(anotacao)){
            BlocoDeNotas notas = new BlocoDeNotas(anotacao, Sessao.getUsuario());
            
            arquivoXML.escreveXML(notas);
        }
    }
    
    public void Alterar(JList lista, String anotacao){
        int indice = 0;
        
        ArrayList<BlocoDeNotas> arquivoNotas = arquivoXML.getLista();
        
        for (BlocoDeNotas notas : arquivoNotas){
            if(notas.getUsuario().equals(Sessao.getUsuario()))    
                if (lista.getSelectedIndex() == indice++){
                    notas.setNota(anotacao);
                    break;
                }      
        }
        
        arquivoXML.escreveXML();
    }
    
    public void Excluir(JList lista, String anotacao){
        int indice = 0;
        
        ArrayList<BlocoDeNotas> arquivoNotas = arquivoXML.getLista();
        
        for (BlocoDeNotas notas : arquivoNotas){
            if(notas.getUsuario().equals(Sessao.getUsuario()))    
                if (lista.getSelectedIndex() == indice++){
                    arquivoXML.getLista().remove(notas);
                    break;
                }      
        }
        
        arquivoXML.escreveXML();
    }
    
    public void EscolherTexto(JList lista, JTextField texto){
        texto.setText((String)lista.getSelectedValue());
    }
    
    public void Voltar(Notas notas){
        notas.dispose();
    }
    
    public void Zerar(JTextField texto){
        texto.setText(null);
    }
    
    /* ---CRITICA DE DADOS--- */
    
    private boolean EmBranco(String anotacao){
        return anotacao.equals("");
    }
}
