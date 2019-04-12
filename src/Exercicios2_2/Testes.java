package Exercicios2_2;


public class Testes {
    
    public static void main(String[] args) {
        PilhaVetor<Integer> teste = new PilhaVetor<>(3);
        teste.push(10);
        teste.push(20);
        teste.push(30);
        PilhaVetor<Integer> teste2 = new PilhaVetor<>(3);
        teste2.push(40);
        teste2.push(50);
        teste.concatenar(teste2);
        System.out.println(teste.toString());
    }
}
