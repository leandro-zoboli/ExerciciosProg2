package Prog_4_3;

import java.util.Observable;
import java.util.Observer;

public class Clima2 implements Observer {

    private double maiorTemperatura;
    private double menorTemperatura;

    @Override
    public void update(Observable o, Object arg) {
        Clima clima = (Clima) o;
        if (clima.getTemperatura() > maiorTemperatura) {
            maiorTemperatura = clima.getTemperatura();
        }
        if (clima.getTemperatura() < menorTemperatura) {
            menorTemperatura = clima.getTemperatura();
        }
        System.out.println("(Classe Clima2) A maior temperatura foi de " + this.maiorTemperatura + "ºC");
        System.out.println("(Classe Clima2) A menor temperatura foi de " + this.menorTemperatura + "ºC");
    }
}
