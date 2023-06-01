package oop.karty.Bezpozicie;

import oop.hra.Plocha;
import oop.karty.Karta;

public class KacaciTanec extends Karta {

    public KacaciTanec(String nazov) {
        super(nazov);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        plocha.getBalicekKariet().addAll(plocha.getPolicka());
        plocha.nastavenieKariet(plocha.getBalicekKariet());
        return true;
    }
}
