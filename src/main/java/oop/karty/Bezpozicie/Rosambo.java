package oop.karty.Bezpozicie;

import oop.hra.Plocha;
import oop.karty.Karta;

public class Rosambo extends Karta {

    public Rosambo(String nazov) {
        super(nazov);
    }

    @Override
    public boolean hrajKartu(Plocha plocha) {
        plocha.premiesanie(plocha.getPolicka());
        return true;
    }
}