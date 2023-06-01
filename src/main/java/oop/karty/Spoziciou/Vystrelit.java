package oop.karty.Spoziciou;

import oop.hra.Plocha;

public class Vystrelit extends AkcneKartySVyberomPolicka {

    public Vystrelit(String meno) {
        super(meno);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        this.setPoziciaKacky(vyberKartu());
        if(plocha.getZamierenePolicko(this.getPoziciaKacky())){
            this.vystrel(plocha);
            return true;
        }
        else{
            System.out.println("Na toto policko este nie je zamierene.");
            return false;
        }
    }
}
