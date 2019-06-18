package Algoritmos_5_2;

public abstract class OrdenacaoAbstract<T extends Comparable> {

    private T[] info;

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    public void trocar(int a, int b) {
        T aux = info[a];
        info[a] = info[b];
        info[b] = aux;
    }

    public abstract void ordenar();
}
