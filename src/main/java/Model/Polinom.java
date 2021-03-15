package Model;

import java.util.*;


public class Polinom {
    public List<Monom> pol = new ArrayList<>();

    public Polinom() {
    }

    public void construirePol(Monom m) {
        boolean sem = false;
        int aux = 0;
        for (int i = 0; i < pol.size(); i++) {
            if (m.getPutere() == pol.get(i).getPutere()) {
                sem = true;
                aux = i;
            }
        }
        if (sem == true) {
            pol.get(aux).setCoef(pol.get(aux).getCoef() + m.getCoef());
        } else {
            pol.add(m);
        }
    }

    public void construirePol1(Monom m) {
        boolean sem = false;
        int aux = 0;
        for (int i = 0; i < pol.size(); i++) {
            if (m.getPutere() == pol.get(i).getPutere()) {
                sem = true;
                aux = i;
            }
        }
        if (sem == true) {
            pol.get(aux).setCoef(pol.get(aux).getCoef() - m.getCoef());
        } else {
            Monom monom = new Monom(m.getPutere(), -m.getCoef());
            pol.add(monom);
        }
    }

    public void construirePol2(Monom m1) {
        for (Monom m : pol) {
            m.setPutere(m.getPutere() + m1.getPutere());
            m.setCoef(m.getCoef() * m1.getCoef());
        }
    }

    public boolean verif() {
        Boolean sem = true;
        for (Monom m1 : pol) {
            if (m1.getCoef() != 0.0D) {
                sem = false;
            }
        }
        return sem;
    }


    public Monom maxim() {
        int max = -1;
        Monom rezultat = new Monom(0, 0.0D);
        for (Monom mon : pol) {
            if (mon.getCoef() != 0.0D && mon.getPutere() > max) {
                max = mon.getPutere();
                rezultat = mon;
            }
        }
        return rezultat;
    }


    public String toString() {
        String rezultat = "";
        Collections.sort(pol);
        if (verif() == false) {
            for (Monom monom : pol) {
                String p = Integer.toString(monom.getPutere());
                String c = Double.toString(monom.getCoef());
                if (monom.getCoef() < 0.0D) {
                    rezultat = rezultat + c + "X^" + p + " ";
                } else if (monom.getCoef() != 0.0D) {
                    if (monom.getPutere() != this.gradMax()) {
                        rezultat = rezultat + "+" + c + "X^" + p + " ";
                    } else {
                        rezultat = rezultat + c + "X^" + p + " ";
                    }
                }
            }
        } else {
            rezultat = rezultat + "0X^0";
        }
        return rezultat;
    }

    public int gradMax() {
        int maxim = -1;
        for (Monom m1 : pol) {
            if (m1.getPutere() > maxim && m1.getCoef() != 0.0D) {
                maxim = m1.getPutere();
            }
        }
        return maxim;
    }


}
