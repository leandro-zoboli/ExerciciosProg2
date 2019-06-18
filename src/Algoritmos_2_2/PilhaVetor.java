package Algoritmos_2_2;


public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int limite;
    private int tamanho;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public PilhaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    public void push(T info) {
        if (this.limite == this.tamanho) {
            throw new PilhaCheiaException();
        }
        this.info[this.tamanho] = info;
        this.tamanho++;
    }

    public T peek() {
        if (this.tamanho == 0) {
            throw new PilhaVaziaException();
        }
        return this.info[this.tamanho - 1];
    }

    public T pop() {
        if (this.tamanho == 0) {
            throw new PilhaVaziaException();
        }
        T aux = this.info[tamanho - 1];
        this.tamanho--;
        return aux;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void liberar() {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        String retorno = "";
        for (int index = this.tamanho - 1; index >= 0; index--) {
            retorno += this.info[index].toString();
            if (index != 0) {
                retorno += ",";
            }
        }
        return retorno;
    }

    public void concatenar(PilhaVetor<T> p) {
        T[] aux = (T[]) new Object[this.limite + p.getLimite()];
        int contAux = 0;
        for (int index = 0; index < this.tamanho; index++) {
            aux[contAux] = this.info[index];
            contAux++;
        }
        for (int index = 0; index < p.getTamanho(); index++) {
            aux[contAux] = p.getInfo()[index];
            contAux++;
        }
        info = aux;
        tamanho = this.tamanho + p.getTamanho();
    }
}
