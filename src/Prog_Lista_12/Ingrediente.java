package Prog_Lista_12;

public class Ingrediente {
    
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
    public Ingrediente(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString(){
            return nome;
    }
}
