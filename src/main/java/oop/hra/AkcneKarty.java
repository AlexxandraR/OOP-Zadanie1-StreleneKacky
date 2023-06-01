package oop.hra;

import oop.karty.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AkcneKarty {
    private List<Karta> karty;

    public AkcneKarty(List<Karta> karty) {
        this.karty = karty;
        Collections.shuffle(this.karty);
    }

   public void setKarty(List<Karta> karty) {
        this.karty = karty;
    }

    public List<Karta> getKarty() {
        return karty;
    }

    public void rozdanieKariet(Hrac hrac){
        int pocetKariet = this.karty.size();
        List<Karta> kartyHraca = new ArrayList<>();
        List<Karta> kartyKopky = new ArrayList<>();
        for(int i = 0; i < pocetKariet; i++){
            if(i < 3){
                kartyHraca.add(this.karty.get(i));
            }
            else{
                kartyKopky.add(this.karty.get(i));
            }
        }
        hrac.setKarty(kartyHraca);
        this.setKarty(kartyKopky);
    }

    public void potiahnutieKarty(Hrac hrac, int indexKarty){
        this.karty.add(hrac.getKarty().remove(indexKarty));
        hrac.getKarty().add(this.karty.remove(0));
    }
}