package Algoritmos_2_2;


public interface Pilha<T> {
    public void push(T info);
    public T pop();
    public T peek();
    public boolean estaVazia();
    public void liberar();
}
