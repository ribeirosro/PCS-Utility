package Controle;

import Classes.ArquivoXML;
import App.Tarefas;
import Classes.BlocoDeNotas;
import Classes.Sessao;
import Classes.Tarefa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

import javax.swing.JList;
import javax.swing.JTextField;

public class TarefasControle {
    ArquivoXML<Tarefa> arquivoXML = new ArquivoXML<>("tarefas.XML");
    
    public TarefasControle(){
        arquivoXML.leXML();
    }
    
    public void Visualizar(JList lista){
        arquivoXML.leXML();
        
        DefaultListModel dlm = new DefaultListModel();
        
        ArrayList<Tarefa> arquivoTarefas = arquivoXML.getLista();
        
        Collections.sort(arquivoTarefas, new Prioridade());
        
        for (Tarefa aux : arquivoTarefas){
            if(aux.getUsuario().equals(Sessao.getUsuario()))
                dlm.addElement(aux.getPrioridade() + " - " + aux.getNota());
        }
        
        lista.setModel(dlm);
    }
    
    public void Inserir(String anotacao, int propriedade){
        if (!EmBranco(anotacao)){
            Tarefa tarefa = new Tarefa(anotacao, Sessao.getUsuario(), propriedade);
            
            arquivoXML.escreveXML(tarefa);
        }       
    }
    
    public void Alterar(JList lista, String anotacao, int propriedade){
        int indice = 0;
        
        ArrayList<Tarefa> arquivoNotas = arquivoXML.getLista();
        
        for (Tarefa aux : arquivoNotas){
            if(aux.getUsuario().equals(Sessao.getUsuario()))    
                if (lista.getSelectedIndex() == indice++){
                    aux.setNota(anotacao);
                    aux.setPrioridade(propriedade);
                    break;
                }      
        }
        
        arquivoXML.escreveXML();
    }
    
    public void Excluir(JList lista){
        int indice = 0;
        
        ArrayList<Tarefa> arquivoNotas = arquivoXML.getLista();
        
        for (Tarefa aux : arquivoNotas){
            if(aux.getUsuario().equals(Sessao.getUsuario()))    
                if (lista.getSelectedIndex() == indice++){
                    arquivoXML.getLista().remove(aux);
                    break;
                }      
        }
        
        arquivoXML.escreveXML();
    }
    
    public void EscolherTexto(JList lista, JTextField texto, JComboBox prioridade){
        String aux = (String)lista.getSelectedValue();
        
        String aux1 = aux.substring(0, 1);
        String aux2 = aux.substring(4);
        
        texto.setText(aux2);
        prioridade.setSelectedIndex(Integer.parseInt(aux1)-1);
        
    }
    
    public void Voltar(Tarefas tarefas){
        tarefas.dispose();
    }
    
    public void Zerar(JTextField texto, JComboBox prioridade){
        texto.setText(null);
        
        prioridade.setSelectedIndex(0);
    }
    
    /* ---CRITICA DE DADOS--- */
    
    private boolean EmBranco(String anotacao){
        return anotacao.equals("");
    }
    
    private class Prioridade implements Comparator<Tarefa>{
        @Override
        public int compare(Tarefa t1, Tarefa t2){
            return t1.getPrioridade() > t2.getPrioridade() ? -1 : (t1.getPrioridade() < t2.getPrioridade() ? +1 : 0);
        }
    }
    
}
