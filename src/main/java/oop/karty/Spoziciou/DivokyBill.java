package oop.karty.Spoziciou;

import oop.hra.Plocha;

public class DivokyBill extends AkcneKartySVyberomPolicka {

    public DivokyBill(String meno) {
        super(meno);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        this.setPoziciaKacky(vyberKartu());
        vystrel(plocha);
        return true;
    }
}
