package Prog_4_3;

import java.util.Observable;
import java.util.Observer;

public class Clima1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Clima clima = (Clima) o;
        if (clima.getTemperatura() <= 15) {
            System.out.println("(Classe Clima1) O tempo está frio");
        } else if (clima.getTemperatura() <= 27) {
            System.out.println("(Classe Clima1) A temperatura está moderada");
        } else {
            System.out.println("(Classe Clima1) O tempo está quente");
        }
    }
}
