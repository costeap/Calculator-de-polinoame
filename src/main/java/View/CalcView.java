package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame {
    private JPanel contentPane;
    private JLabel titlu;
    private JTextField primulPol;
    private JTextField alDoileaPol;
    private JLabel primulPolinom;
    private JLabel alDoileaPolinom;
    private JLabel rezultat;
    private JLabel rezultat1;
    private JLabel rez;
    private JButton adunare;
    private JButton scadere;
    private JButton inmultire;
    private JButton impartire;
    private JButton derivare;
    private JButton integrare;
    private JButton clear;

    public CalcView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 620, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(203, 184, 205));


        titlu = new JLabel("POLYNOMIAL CALCULATOR");
        titlu.setFont(new Font("Ink Free", Font.BOLD, 18));
        titlu.setBounds(130, 20, 300, 70);
        contentPane.add(titlu);

        primulPolinom = new JLabel("First Polynomial:");
        primulPolinom.setFont(new Font("Ink Free", Font.BOLD, 16));
        primulPolinom.setBounds(27, 80, 200, 20);
        contentPane.add(primulPolinom);

        alDoileaPolinom = new JLabel("Second Polynomial:");
        alDoileaPolinom.setFont(new Font("Ink Free", Font.BOLD, 16));
        alDoileaPolinom.setBounds(20, 130, 200, 20);
        contentPane.add(alDoileaPolinom);

        primulPol = new JTextField();
        primulPol.setBackground(new Color(200, 220, 230));
        primulPol.setBounds(160, 82, 400, 20);
        contentPane.add(primulPol);
        primulPol.setColumns(10);

        alDoileaPol = new JTextField();
        alDoileaPol.setBackground(new Color(200, 220, 230));
        alDoileaPol.setBounds(160, 132, 400, 20);
        contentPane.add(alDoileaPol);
        alDoileaPol.setColumns(10);

        rez = new JLabel("Result:");
        rez.setFont(new Font("Ink Free", Font.BOLD, 16));
        rez.setBounds(58, 180, 200, 20);
        contentPane.add(rez);

        rezultat = new JLabel("");
        rezultat.setFont(new Font("Ink Free", Font.BOLD, 16));
        rezultat.setBounds(160, 182, 400, 20);
        contentPane.add(rezultat);

        rezultat1 = new JLabel("");
        rezultat1.setFont(new Font("Ink Free", Font.BOLD, 16));
        rezultat1.setBounds(160, 202, 400, 20);
        contentPane.add(rezultat1);

        adunare = new JButton("Add");
        adunare.setBackground(new Color(207, 165, 214));
        adunare.setFont(new Font("Ink Free", Font.BOLD, 16));
        adunare.setBounds(100, 230, 120, 40);
        contentPane.add(adunare);

        scadere = new JButton("Substract");
        scadere.setBackground(new Color(207, 165, 214));
        scadere.setFont(new Font("Ink Free", Font.BOLD, 16));
        scadere.setBounds(300, 230, 120, 40);
        contentPane.add(scadere);

        inmultire = new JButton("Multiply");
        inmultire.setBackground(new Color(207, 165, 214));
        inmultire.setFont(new Font("Ink Free", Font.BOLD, 16));
        inmultire.setBounds(100, 280, 120, 40);
        contentPane.add(inmultire);

        impartire = new JButton("Divide");
        impartire.setBackground(new Color(207, 165, 214));
        impartire.setFont(new Font("Ink Free", Font.BOLD, 16));
        impartire.setBounds(300, 280, 120, 40);
        contentPane.add(impartire);

        derivare = new JButton("Derivate");
        derivare.setBackground(new Color(207, 165, 214));
        derivare.setFont(new Font("Ink Free", Font.BOLD, 16));
        derivare.setBounds(100, 330, 120, 40);
        contentPane.add(derivare);

        integrare = new JButton("Integrate");
        integrare.setBackground(new Color(207, 165, 214));
        integrare.setForeground(new Color(50, 50, 50));
        integrare.setFont(new Font("Ink Free", Font.BOLD, 16));
        integrare.setBounds(300, 330, 120, 40);
        contentPane.add(integrare);

        clear = new JButton("Clear");
        clear.setBackground(new Color(207, 165, 214));
        clear.setFont(new Font("Ink Free", Font.BOLD, 16));
        clear.setBounds(200, 420, 120, 40);
        contentPane.add(clear);

    }

    public void adunareListener(ActionListener actionListener) {
        this.adunare.addActionListener(actionListener);
    }

    public void scadereListener(ActionListener actionListener) {
        this.scadere.addActionListener(actionListener);
    }

    public void inmultireListener(ActionListener actionListener) {
        this.inmultire.addActionListener(actionListener);
    }

    public void impartireListener(ActionListener actionListener) {
        this.impartire.addActionListener(actionListener);
    }

    public void derivareListener(ActionListener actionListener) {
        this.derivare.addActionListener(actionListener);
    }

    public void integrareListener(ActionListener actionListener) {
        this.integrare.addActionListener(actionListener);
    }

    public void clearListener(ActionListener actionListener) {
        this.clear.addActionListener(actionListener);
    }

    public String getUserInput1() {
        return this.primulPol.getText();
    }

    public String getUserInput2() {
        return this.alDoileaPol.getText();
    }

    public void updateRezultatLabel(String newValue) {
        this.rezultat.setText((newValue));
    }

    public void updateRezultat1Label(String newValue) {
        this.rezultat1.setText((newValue));
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
}
