package Controller;

import Model.Operatii;
import Model.Polinom;
import View.CalcView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private CalcView cw;

    public CalcController(CalcView cw) {
        this.cw = cw;
        this.cw.adunareListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                Polinom rezultat = new Polinom();
                Operatii o = new Operatii();
                try {
                    pol1 = o.formarePolinom(cw.getUserInput1());
                    pol2 = o.formarePolinom(cw.getUserInput2());
                    rezultat = Operatii.adunarePoli(pol1, pol2);
                    System.out.println(rezultat.toString());
                    cw.updateRezultatLabel(rezultat.toString());
                } catch (Exception ex) {
                    cw.showError("Bad input!");
                }
            }
        });

        this.cw.scadereListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                Polinom rezultat = new Polinom();
                Operatii o = new Operatii();
                try {
                    pol1 = o.formarePolinom(cw.getUserInput1());
                    pol2 = o.formarePolinom(cw.getUserInput2());
                    rezultat = Operatii.scaderePoli(pol1, pol2);
                    System.out.println(rezultat.toString());
                    cw.updateRezultatLabel(rezultat.toString());
                } catch (Exception ex) {
                    cw.showError("Bad input!");
                }
            }
        });

        this.cw.inmultireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                Polinom rezultat = new Polinom();
                Operatii o = new Operatii();
                try {
                    pol1 = o.formarePolinom(cw.getUserInput1());
                    pol2 = o.formarePolinom(cw.getUserInput2());
                    rezultat = Operatii.inmultirePoli(pol1, pol2);
                    System.out.println(rezultat.toString());
                    cw.updateRezultatLabel(rezultat.toString());
                } catch (Exception ex) {
                    cw.showError("Bad input!");
                }
            }
        });
        this.cw.derivareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom pol1 = new Polinom();
                Polinom rezultat = new Polinom();
                Operatii o = new Operatii();
                try {
                    pol1 = o.formarePolinom(cw.getUserInput1());
                    rezultat = Operatii.derivarePol(pol1);
                    System.out.println(rezultat.toString());
                    cw.updateRezultatLabel(rezultat.toString());
                } catch (Exception ex) {
                    cw.showError("Bad input!");
                }
            }
        });
        this.cw.integrareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom pol1 = new Polinom();
                Polinom rezultat = new Polinom();
                Operatii o = new Operatii();
                try {
                    pol1 = o.formarePolinom(cw.getUserInput1());
                    rezultat = Operatii.integrarePol(pol1);
                    System.out.println(rezultat.toString());
                    cw.updateRezultatLabel(rezultat.toString());
                } catch (Exception ex) {
                    cw.showError("Bad input!");
                }
            }
        });
        this.cw.impartireListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();
                Polinom rezultat[];
                Operatii o = new Operatii();
                try {
                    pol1 = o.formarePolinom(cw.getUserInput1());
                    pol2 = o.formarePolinom(cw.getUserInput2());
                    rezultat = Operatii.impartirePoli(pol1, pol2);
                    System.out.println(rezultat.toString());
                    cw.updateRezultatLabel("Q: " + rezultat[0].toString());
                    cw.updateRezultat1Label("R: " + rezultat[1].toString());
                } catch (Exception ex) {
                    cw.showError("Bad input!");
                }
            }
        });
        this.cw.clearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cw.updateRezultatLabel("");
                cw.updateRezultat1Label("");
            }
        });
    }
}
