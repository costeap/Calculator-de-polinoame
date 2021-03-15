package Model;

import java.util.Collections;
import java.util.regex.Pattern;

public class Operatii {
    public Operatii() {
    }

    ;

    public static Polinom auxiliar(Polinom p) {
        Polinom rezultat = new Polinom();
        for (Monom m : p.pol) {
            Monom mon = new Monom(m.getPutere(), m.getCoef());
            rezultat.pol.add(mon);
        }
        return rezultat;
    }


    public Polinom formarePolinom(String sir1) {
        Polinom obtinut = new Polinom();
        String[] sir2 = sir1.split(Pattern.quote("+"));
        for (int i = 0; i < sir2.length; ++i) {
            Monom mo = new Monom(0, 0.0D);
            int pozx = sir2[i].indexOf("X");
            if (sir2[i].indexOf("-") == -1)    ///daca nu avem numere negative
            {
                if (pozx != 0) {
                    mo.setCoef((float) Integer.parseInt(sir2[i].substring(0, pozx)));

                } else {
                    mo.setCoef(1.0D);
                }
            } else if (pozx != 1) {
                mo.setCoef((float) (-Integer.parseInt(sir2[i].substring(1, pozx))));
            } else {
                mo.setCoef(-1.0D);
            }
            mo.setPutere(Integer.parseInt(sir2[i].substring(sir2[i].indexOf("^") + 1)));
            obtinut.pol.add(mo);

        }
        Collections.sort(obtinut.pol);
        return obtinut;

    }


    public static Polinom adunarePoli(Polinom pol1, Polinom pol2) {
        Polinom rezultat = new Polinom();
        for (Monom m1 : pol1.pol) {
            Monom mon = new Monom(m1.getPutere(), m1.getCoef());
            rezultat.pol.add(mon);
        }
        for (Monom m2 : pol2.pol) {
            Monom mon = new Monom(m2.getPutere(), m2.getCoef());
            rezultat.construirePol(mon);
        }
        return rezultat;
    }


    public static Polinom scaderePoli(Polinom pol1, Polinom pol2) {
        Polinom rezultat = new Polinom();
        for (Monom m1 : pol1.pol) {
            Monom mon = new Monom(m1.getPutere(), m1.getCoef());
            rezultat.pol.add(mon);
        }
        for (Monom m2 : pol2.pol) {
            Monom mon = new Monom(m2.getPutere(), m2.getCoef());
            rezultat.construirePol1(mon);
        }
        return rezultat;
    }


    public static Polinom inmultirePoli(Polinom pol1, Polinom pol2) {
        Polinom rezultat = new Polinom();
        Polinom rezultatFinal = new Polinom();
        Monom m;

        for (Monom m1 : pol1.pol) {
            for (Monom m2 : pol2.pol) {
                m = new Monom(m1.getPutere() + m2.getPutere(), m1.getCoef() * m2.getCoef());
                rezultat.pol.add(m);
            }
        }
        int putereMaxima = ((Monom) rezultat.pol.get(0)).getPutere();
        for (int i = putereMaxima; i >= 0; i--) {
            double coeff = 0;
            for (Monom monomm : rezultat.pol) {
                if (monomm.getPutere() == i) {
                    coeff = coeff + monomm.getCoef();
                }
            }
            if (coeff != 0) {
                Monom monomm = new Monom(i, coeff);
                rezultatFinal.pol.add(monomm);
            }
        }
        return rezultatFinal;
    }


    public static Polinom[] impartirePoli(Polinom pol1, Polinom pol2) {
        Polinom q = new Polinom();
        Polinom r = new Polinom();
        r = auxiliar(pol1);
        Monom init = new Monom(0, 0.0D);
        q.pol.add(init);
        Monom rMax = r.maxim();
        for (Monom monom2 = pol2.maxim(); !r.verif() && rMax.getPutere() >= monom2.getPutere(); rMax = r.maxim()) {
            Polinom copie = auxiliar(pol2);
            Monom mon = new Monom(rMax.getPutere() - monom2.getPutere(), rMax.getCoef() / monom2.getCoef());
            q.construirePol(mon);
            copie.construirePol2(mon);
            r = scaderePoli(r, copie);
        }
        Polinom[] rezultat = new Polinom[]{q, r};
        return rezultat;
    }

    public static Polinom derivarePol(Polinom p) {
        Polinom rezultat = new Polinom();
        for (Monom m : p.pol) {
            if (m.getPutere() != 0) {
                Monom m1 = new Monom(m.getPutere() - 1, m.getCoef() * m.getPutere());
                rezultat.pol.add(m1);
            }
        }
        return rezultat;
    }

    public static Polinom integrarePol(Polinom p) {
        Polinom rezultat = new Polinom();
        for (Monom m : p.pol) {
            Monom m1 = new Monom(m.getPutere() + 1, m.getCoef() / (float) (m.getPutere() + 1));
            rezultat.pol.add(m1);
        }
        return rezultat;
    }

}
