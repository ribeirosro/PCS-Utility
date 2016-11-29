package Controle;

import Classes.ArquivoXML;
import App.Login;
import App.Cadastro;

import Classes.Cliente;
import javax.swing.JOptionPane;

public class CadastroControle {
    ArquivoXML<Cliente> arquivoXML = new ArquivoXML<>("clientes.XML");
    
    public CadastroControle(){
        arquivoXML.leXML();
    }
    public void Cadastrar(String usuario, String senha, Cadastro cadastro){
        if (!EmBranco(usuario, senha)){
            /* ---CADASTRAR CLIENTE---*/
            
            Cliente cliente = new Cliente(usuario, senha);
            arquivoXML.escreveXML(cliente);
            
            JOptionPane.showMessageDialog(cadastro,"Cliente cadastrado com sucesso.");
            
            /* ---VOLTAR A TELA DE LOGIN--- */
            
            cadastro.dispose();
            
            Login login = new Login();
            login.setVisible(true);
            
        } else JOptionPane.showMessageDialog(cadastro,"Usuário e/ou senha em branco.");
    }
    
    public void Cancelar (Cadastro cadastro){
        Login form = new Login();
        form.setVisible(true);
        
        cadastro.dispose();
    }
    
    /* ---CRITICA DE DADOS--- */
    
    private boolean EmBranco(String usuario, String senha){
        return usuario.equals("") || senha.equals("");
    }
}
