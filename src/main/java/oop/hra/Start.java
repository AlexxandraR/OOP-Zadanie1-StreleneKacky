package oop.hra;

import oop.karty.*;
import oop.karty.Bezpozicie.*;
import oop.karty.Spoziciou.*;
import oop.utility.ZKlavesnice;

import java.util.*;

public class Start {
    protected Hrac[] hraci;
    protected int pocetHracov = 0;
    protected Plocha plocha;
    protected AkcneKarty akcneKarty;
    protected int aktivnyHrac = -1;

    public Start() {
        System.out.println("STRELENE KACKY");
        inicializaciaAkcnychKariet();
        inicializaciaHracov();
        inicializaciaPlochy();
        zaciatokHry();
    }

    private void inicializaciaHracov(){
        while(pocetHracov < 2 || pocetHracov > 6){
            pocetHracov = ZKlavesnice.readInt("Zadaj pocet hracov (2-6):");
        }
        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i < pocetHracov; i++){
            String menoHraca = ZKlavesnice.readString("Zadaj meno " + (i + 1) + ". hraca:");
            this.hraci[i] = new Hrac(menoHraca);
            akcneKarty.rozdanieKariet(this.hraci[i]);
        }
    }

    private void inicializaciaPlochy(){
        List<Hrac> pole = new ArrayList<>();
        for (int i = 0; i < pocetHracov+1; i++){
            for(int j = 0; j < 5; j++){
                if(i < pocetHracov){
                    pole.add(hraci[i]);
                }
                else{
                    pole.add(new Hrac("Voda"));
                }
            }
        }
        boolean[] zameriat = {false, false, false, false, false, false};
        this.plocha = new Plocha(pole, zameriat);
    }

    private void inicializaciaAkcnychKariet(){
        List<Karta> docasne = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            docasne.add(new Zameriavac("Zameriavac"));
        }
        for (int i = 0; i < 12; i++){
            docasne.add(new Vystrelit("Vystrelit"));
        }
        for (int i = 0; i < 2; i++){
            docasne.add(new DivokyBill("Divoky Bill"));
        }
        for (int i = 0; i < 6; i++){
            docasne.add(new KacaciPochod("Kacaci Pochod"));
        }
        docasne.add(new TurboKacka("Turbokacka"));
        for (int i = 0; i < 2; i++){
            docasne.add(new Rosambo("Rosambo"));
        }
        docasne.add(new KacaciTanec("Kacaci Tanec"));
        this.akcneKarty = new AkcneKarty(docasne);
    }

    private void zaciatokHry(){
        System.out.println("\nZACIATOK HRY\n");
        int indexKarty = -1;
        boolean hratelna;

        while(!koniecHry()){
            hratelna = false;
            plocha.vykresli();

            this.aktivnyHrac = this.hracNaRade(this.hraci);

            System.out.println();
            System.out.println("Na tahu je hrac: " + this.hraci[this.aktivnyHrac].getMeno());
            System.out.println("Pocet zivotov hraca: " + this.hraci[this.aktivnyHrac].getPocetZivotov());
            System.out.print("Tvoje karty su: ");
            this.hraci[this.aktivnyHrac].vypis();
            System.out.println();

            if (!this.daSaZahrat()){
                indexKarty = -1;
                while (indexKarty < 0 || indexKarty > 2){
                    indexKarty = ZKlavesnice.readInt("Nemozes zahrat ani jednu kartu. Ktoru kratu chces vyhodit? Zadaj cislo od 1-3:")-1;
                }
            }

            else{
                while(!hratelna) {
                    indexKarty = -1;
                    while (indexKarty < 0 || indexKarty > 2) {
                        indexKarty = ZKlavesnice.readInt("Ktoru kartu chces pouzit? Zadaj cislo 1-3:") - 1;
                    }

                    hratelna = this.hraci[this.aktivnyHrac].getKarty().get(indexKarty).hrajKartu(plocha);
                }
            }
            this.akcneKarty.potiahnutieKarty(this.hraci[this.aktivnyHrac], indexKarty);
        }
        for(Hrac i : hraci){
            if(i.getPocetZivotov() > 0){
                System.out.println("Vitazom je hrac " + i.getMeno());
            }
        }
    }

    private int hracNaRade(Hrac[] hraci){
        while(true){
            if(aktivnyHrac < pocetHracov-1){
                aktivnyHrac++;
            }
            else{
                aktivnyHrac = 0;
            }
            if(hraci[aktivnyHrac].getPocetZivotov() > 0){
                return aktivnyHrac;
            }
            else{
                if(hraci[aktivnyHrac].getKarty() != null){
                    for(Karta karta : hraci[aktivnyHrac].getKarty()){
                        //System.out.println(karta.getNazov());
                        this.akcneKarty.getKarty().add(karta);
                    }
                    hraci[aktivnyHrac].setKarty(null);
                }
            }
        }
    }

    private boolean vsetkyTrue(boolean[] pole){
        for(boolean b : pole){
            if(!b){
                return false;
            }
        }
        return true;
    }

    private boolean vsetkyFalse(boolean[] pole){
        for(boolean b : pole){
            if(b){
                return false;
            }
        }
        return true;
    }

    private boolean daSaZahrat(){
        if(vsetkyTrue(plocha.getZamierenePolicko())){
            for(Karta karta : this.hraci[this.aktivnyHrac].getKarty()){
                if(!Objects.equals(karta.getNazov(), "Zameriavac")){
                    return true;
                }
            }
            return false;
        }
        if(vsetkyFalse(plocha.getZamierenePolicko())){
            for(Karta karta : this.hraci[this.aktivnyHrac].getKarty()){
                if(!Objects.equals(karta.getNazov(), "Vystrelit")){
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean koniecHry(){
        int pocet = 0;
        for(Hrac i : hraci){
            if(i.getPocetZivotov() > 0){
                pocet++;
            }
        }
        return pocet <= 1;
    }
}