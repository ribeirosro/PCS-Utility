package Classes;


public class Tarefa {
    private String nota, usuario;
    private int prioridade;
    
    public Tarefa(){
        nota = usuario = "";
        prioridade = 0;
    }
    
    public Tarefa(String nota, String usuario, int prioridade){
        this.nota = nota;
        this.usuario = usuario;
        this.prioridade = prioridade;
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
    
    public int getPrioridade(){
        return prioridade;
    }
    
    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }
}
