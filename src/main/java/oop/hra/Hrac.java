package oop.hra;

import oop.karty.Karta;

import java.util.ArrayList;
import java.util.List;

public class Hrac {
    private final String meno;
    private int pocetZivotov;
    private List<Karta> karty;

    public Hrac(String meno){
        this.meno = meno;
        this.pocetZivotov = 5;
        this.karty = new ArrayList<>();
    }

    public String getMeno() {
        return meno;
    }

    public void vypis(){
        for (Karta i : this.karty) {
            System.out.print(i.getNazov() + "   ");
        }
    }

    public void setKarty(List<Karta> karty) {
        this.karty = karty;
    }

    public List<Karta> getKarty() {
        return karty;
    }

    public int getPocetZivotov() {
        return pocetZivotov;
    }

    public void setPocetZivotov(int pocetZivotov) {
        this.pocetZivotov = pocetZivotov;
    }

    public void vypisMeno() {
        System.out.println(this.meno);
    }

}