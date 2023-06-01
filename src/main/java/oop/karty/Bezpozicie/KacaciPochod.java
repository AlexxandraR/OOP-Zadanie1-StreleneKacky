package oop.karty.Bezpozicie;

import oop.hra.Plocha;
import oop.karty.Karta;

public class KacaciPochod extends Karta {

    public KacaciPochod(String nazov) {
        super(nazov);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        plocha.pochod(0);
        return true;
    }
}
