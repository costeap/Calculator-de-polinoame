package Model;

public class Monom implements Comparable<Monom> {
    public int putere;
    public double coef;

    public Monom(int putere, double coef) {
        this.putere = putere;
        this.coef = coef;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }


    public String toString1(Monom m) {

        return "+" + m.getCoef() + "X^" + m.getPutere();
    }

    @Override
    public int compareTo(Monom m1) {
        if (m1.getPutere() > this.getPutere())
            return 1;
        else if (m1.getPutere() < this.getPutere())
            return -1;
        else return 0;
    }


}
