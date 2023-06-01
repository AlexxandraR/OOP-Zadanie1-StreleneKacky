package oop.karty;

import oop.hra.Plocha;

public abstract class Karta{
    protected String nazov;

    public Karta(String nazov) {
        this.nazov = nazov;
    }

    public boolean hrajKartu(Plocha plocha){return true;}

    public String getNazov() {
        return nazov;
    }
}
