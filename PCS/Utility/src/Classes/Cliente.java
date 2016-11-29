package Classes;

public class Cliente {
    
    private String usuario, senha;
    
    public Cliente(){
        this.usuario = this.senha = "";
    }
    
    public Cliente(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public String getUsuario (){
        return usuario;
    }
    
    public void setUsuario (String usuario){
        this.usuario = usuario;
    }
    
    public String getSenha (){
        return senha;
    }
    
    public void setSenha (String senha){
        this.senha = senha;
    }
    
}
