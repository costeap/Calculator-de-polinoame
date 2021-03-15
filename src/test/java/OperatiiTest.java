import Model.Operatii;
import Model.Polinom;
import org.junit.Assert;
import org.junit.Test;

public class OperatiiTest {
    public OperatiiTest() {
    }

    ;

    @Test
    public void adunareTest() {
        Operatii o = new Operatii();
        Polinom pol1 = o.formarePolinom("5X^2+-3X^4");
        Polinom pol2 = o.formarePolinom("-6X^3+-7X^2");
        Polinom rezultat = o.adunarePoli(pol1, pol2);
        Assert.assertEquals("-3.0X^4 -6.0X^3 -2.0X^2 ", rezultat.toString());
    }


    @Test
    public void scadereTest() {
        Operatii o = new Operatii();
        Polinom p1 = o.formarePolinom("5X^2+-3X^4");
        Polinom p2 = o.formarePolinom("-6X^3+-7X^2");
        Polinom rezultat = o.scaderePoli(p1, p2);
        Assert.assertEquals("-3.0X^4 +6.0X^3 +12.0X^2 ", rezultat.toString());
    }

    @Test
    public void inmultireTest() {
        Operatii o = new Operatii();
        Polinom p1 = o.formarePolinom("5X^2+-3X^4");
        Polinom p2 = o.formarePolinom("-6X^3+-7X^2");
        Polinom rezultat = o.inmultirePoli(p1, p2);
        Assert.assertEquals("18.0X^7 +21.0X^6 -30.0X^5 -35.0X^4 ", rezultat.toString());
    }

    @Test
    public void impartireTest() {
        Operatii o = new Operatii();
        Polinom p1 = o.formarePolinom("5X^2+-3X^4");
        Polinom p2 = o.formarePolinom("-6X^3+-7X^2");
        Polinom[] rezultat = Operatii.impartirePoli(p1, p2);
        Assert.assertEquals("0.5X^1 -0.5833333333333334X^0 ", rezultat[0].toString());
        Assert.assertEquals("0.9166666666666661X^2 ", rezultat[1].toString());
    }

    @Test
    public void derivareTest() {
        Operatii o = new Operatii();
        Polinom p1 = o.formarePolinom("5X^2+-3X^4");
        Polinom rezultat = Operatii.derivarePol(p1);
        Assert.assertEquals("-12.0X^3 +10.0X^1 ", rezultat.toString());
    }

    @Test
    public void integrareTest() {
        Operatii o = new Operatii();
        Polinom p1 = o.formarePolinom("5X^2+-3X^4");
        Polinom rezultat = Operatii.integrarePol(p1);
        Assert.assertEquals("-0.6X^5 +1.6666666666666667X^3 ", rezultat.toString());
    }

}
