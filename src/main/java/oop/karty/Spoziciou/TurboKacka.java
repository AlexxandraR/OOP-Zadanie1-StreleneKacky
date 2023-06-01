package oop.karty.Spoziciou;

import oop.hra.Hrac;
import oop.hra.Plocha;

public class TurboKacka extends AkcneKartySVyberomPolicka {
    public TurboKacka(String meno) {
        super(meno);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        this.setPoziciaKacky(vyberKartu());
        if(!plocha.getPolicka().get(this.getPoziciaKacky()).getMeno().equals("Voda")){
            Hrac kopia = plocha.getPolicka().get(this.getPoziciaKacky());
            for(int i = this.getPoziciaKacky(); i > 0; i--){
                plocha.getPolicka().set(i, plocha.getPolicka().get(i-1));
            }
            plocha.getPolicka().set(0, kopia);
            return true;
        }
        System.out.println("Na kartu voda nesmies pouzit kartu Turbokacka.");
        return false;
    }
}
