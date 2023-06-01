package oop.karty.Spoziciou;

import oop.hra.Plocha;

public class Zameriavac extends AkcneKartySVyberomPolicka {

    public Zameriavac(String meno) {
        super(meno);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        this.setPoziciaKacky(vyberKartu());
        if(!plocha.getZamierenePolicko(this.getPoziciaKacky())){
            plocha.nastavzamierenePolicko(this.getPoziciaKacky(), true);
            return true;
        }
        else{
            System.out.println("Na toto policko uz je zamierene.");
            return false;
        }
    }
}
