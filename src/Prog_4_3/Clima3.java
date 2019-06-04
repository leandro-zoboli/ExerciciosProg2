package Prog_4_3;

import java.util.Observable;
import java.util.Observer;

public class Clima3 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Clima clima = (Clima) o;
        if (clima.getPressao() < 1013) {
            System.out.println("(Classe Clima3) Há maior probabilidade de chuva");
        } else {
            System.out.println("(Classe Clima3) Há pouca probabilidade de chuva");
        }
    }
}
