package Exercicios2_2_4_Prog2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Questao_2 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long anterior = System.currentTimeMillis();

        for (int i = 0; i < 300000; i++) {
            arrayList.add(i);
        }
        System.out.println(System.currentTimeMillis() - anterior);
        anterior = System.currentTimeMillis();

        for (int i = 0; i < 300000; i++) {
            linkedList.add(i);
        }
        System.out.println(System.currentTimeMillis() - anterior);
    }
}
