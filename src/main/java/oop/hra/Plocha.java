package oop.hra;

import java.util.*;

public class Plocha {
    private List<Hrac> balicekKariet;
    private List<Hrac> policka;
    private final boolean[] zamierenePolicko;


    public Plocha(List<Hrac> karty, boolean[] zamierenePolicko) {
        nastavenieKariet(karty);
        this.zamierenePolicko = zamierenePolicko;
    }

    public void nastavenieKariet(List<Hrac> karty){
        int pocetKariet = karty.size();
        this.balicekKariet = karty;
        premiesanie(this.balicekKariet);
        List<Hrac> kartyPlochy = new ArrayList<>();
        List<Hrac> kartyKopky = new ArrayList<>();
        for(int i = 0; i < pocetKariet; i++){
            if(i < 6){
                kartyPlochy.add(this.balicekKariet.get(i));
            }
            else{
                kartyKopky.add(this.balicekKariet.get(i));
            }
        }
        this.policka = kartyPlochy;
        this.balicekKariet = kartyKopky;
    }

    public void premiesanie(List<Hrac> balicek){
        Collections.shuffle(balicek);
    }

    public List<Hrac> getPolicka() {
        return policka;
    }

    public List<Hrac> getBalicekKariet() {
        return balicekKariet;
    }

    public void nastavzamierenePolicko(int index, boolean hodnota) {
        this.zamierenePolicko[index] = hodnota;
    }

    public boolean getZamierenePolicko(int index) {
        return zamierenePolicko[index];
    }

    public boolean[] getZamierenePolicko(){
        return zamierenePolicko;
    }

    public void posun(int index){
        this.policka.remove(index);
        this.policka.add(this.balicekKariet.remove(0));
    }

    public void pochod(int index){
        this.balicekKariet.add(this.policka.remove(index));
        this.policka.add(this.balicekKariet.remove(0));
    }

    public void vypisZamierenia(int index){
        if(this.zamierenePolicko[index]){
            System.out.print("Zamierene: ");
        }
        else{
            System.out.print("Nezamierene: ");
        }
    }

    public void vykresli(){
        int j = 0;
        for (Hrac i : this.policka){
            System.out.print((j+1) + ". ");
            vypisZamierenia(j);
            if(!i.getMeno().equals("Voda")){
                System.out.print("Kacka hraca ");
            }
            i.vypisMeno();
            j++;
        }
    }
}