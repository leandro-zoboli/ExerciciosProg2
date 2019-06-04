package Prog_4_3;

import java.util.Observable;
import java.util.Observer;

public class Clima4 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Clima clima = (Clima) o;
        if (clima.getUmidade() <= 30) {
            System.out.println("(Classe Clima4) O ar está seco");
        } else {
            System.out.println("(Classe Clima4) O ar está úmido");
        }
    }
}
