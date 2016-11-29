package Controle;

import Classes.ArquivoXML;
import App.Cadastro;
import App.Login;
import App.Menu;

import Classes.Cliente;
import Classes.Sessao;

import javax.swing.JOptionPane;

public class LoginControle {        
    public void Cadastro (Login login){
        Cadastro cadastro = new Cadastro();
        cadastro.setVisible(true);
        
        login.dispose();
    }
    
    public void Login(String usuario, String senha, Login login){
        if (!EmBranco(usuario, senha) && ValidaLogin(usuario, senha)){
            Menu menu = new Menu();
            menu.setVisible(true);

            login.dispose();
            
        } else JOptionPane.showMessageDialog(login,"Usuário e/ou senha incorrento(s).");
    }
    
    /* ---CRITICA DE DADOS--- */
    
    private boolean EmBranco(String usuario, String senha){
        return usuario.equals("") || senha.equals("");
    }
    
    private boolean ValidaLogin(String usuario, String senha){
        ArquivoXML<Cliente> arquivoXML = new ArquivoXML<>("clientes.XML");
                
        arquivoXML.leXML();
        
        /* ---COMPARAR OS ELEMENTOS DA LISTA COM O USUARIO/SENHA FORNECIDOS--- */
        for (Cliente cliente : arquivoXML.getLista()){
            if(cliente.getUsuario().equals(usuario) && cliente.getSenha().equals(senha)){
                /* ---ARMAZENA O NOME DO USUÁRIO--- */
                Sessao sessao = new Sessao (cliente.getUsuario());
                
                return true;
            }
        }
        
        
        /*
        for (int i = 0; i < arquivoXMLCliente.getLista().size(); i++){
            return (arquivoXMLCliente.getLista().get(i).getUsuario().equals(usuario) && arquivoXMLCliente.getLista().get(i).getSenha().equals(senha));
        }*/
       
       return false;
    }
}
