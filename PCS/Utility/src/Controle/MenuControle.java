package Controle;

import App.Calendario;
import App.Monetario;
import App.Tarefas;
import App.Notas;
import App.Login;
import App.Menu;
import javax.swing.JOptionPane;

public class MenuControle {
    public void MenuNotas(){
        Notas form = new Notas();
        form.setVisible(true);
    }
    
    public void MenuTarefas(){
        Tarefas form = new Tarefas();
        form.setVisible(true);
    }
    
    public void MenuCalendario(){
        Calendario form = new Calendario();
        form.setVisible(true);
    }
    
    public void MenuMonetario(){
        Monetario form = new Monetario();
        form.setVisible(true);
    }
    
    public void LogOff(Menu menu){
        int opcao = JOptionPane.showConfirmDialog(menu,"Você deseja fazer logoff?", "LOGOFF",JOptionPane.YES_NO_OPTION);
        
        if (opcao != 1){
            Login login = new Login();
            
            login.setVisible(true);
            
            menu.dispose();
        }
    }
}
