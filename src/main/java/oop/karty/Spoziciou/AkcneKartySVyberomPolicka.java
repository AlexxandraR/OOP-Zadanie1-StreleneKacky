package oop.karty.Spoziciou;

import oop.hra.Plocha;
import oop.karty.Karta;
import oop.utility.ZKlavesnice;

public abstract class AkcneKartySVyberomPolicka extends Karta {
    private int poziciaKacky;

    public AkcneKartySVyberomPolicka(String nazov) {
        super(nazov);
    }

    public int vyberKartu(){
        int indexPolicka = -1;
        while (indexPolicka < 0 || indexPolicka > 5) {
            indexPolicka = ZKlavesnice.readInt("Na ktoru poziciu chces pouzit kartu? Zadaj cislo 1-6:") - 1;
        }
        return indexPolicka;
    }

    public void setPoziciaKacky(int poziciaKacky) {
        this.poziciaKacky = poziciaKacky;
    }

    public int getPoziciaKacky() {
        return poziciaKacky;
    }

    public void vystrel(Plocha plocha){
        plocha.nastavzamierenePolicko(this.getPoziciaKacky(), false);
        if(!plocha.getPolicka().get(this.getPoziciaKacky()).getMeno().equals("Voda")){
            plocha.getPolicka().get(this.getPoziciaKacky()).setPocetZivotov(plocha.getPolicka().get(this.getPoziciaKacky()).getPocetZivotov()-1);
            plocha.posun(this.getPoziciaKacky());
        }
    }

}
