package Classes;

public class Sessao {
    private static String usuario;
        
    public Sessao(String usuario){
        Sessao.usuario = usuario;
    }
    
    public static String getUsuario(){
        return Sessao.usuario;
    }
    
}
