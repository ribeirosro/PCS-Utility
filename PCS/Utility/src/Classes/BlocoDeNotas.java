package Classes;


public class BlocoDeNotas {
    private String nota, usuario;
    
    public BlocoDeNotas(){
        nota = usuario = "";
        
    }
    
    public BlocoDeNotas(String nota, String usuario){
        this.nota = nota;
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getNota(){
        return nota;
    }
    
    public void setNota(String anotacao){
        nota = anotacao;
    }
}
