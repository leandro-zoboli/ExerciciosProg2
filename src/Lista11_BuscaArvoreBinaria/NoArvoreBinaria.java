package Lista11_BuscaArvoreBinaria;

public class NoArvoreBinaria<T> {

    private NoArvoreBinaria<T> direita;
    private NoArvoreBinaria<T> esquerda;
    
    private T info;
    
    public NoArvoreBinaria(T info) {
        this.info = info;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria esq, NoArvoreBinaria dir){
        this.info = info;
        direita = dir;
        esquerda = esq;
    }
    
    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}