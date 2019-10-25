package ba.unsa.etf.rpr.tutorijal02;

import java.util.Scanner;

public class Interval {
    private double pocetna = 0, krajnja = 0;
    boolean pripadaPocetna = true, pripadaKrajnja = true;

    public Interval(double pocetna, double krajnja, boolean pripadaPocetna, boolean pripadaKrajnja) {
        if (pocetna > krajnja) throw new IllegalArgumentException("Pogresne tacke!");
        else {
            this.pocetna = pocetna;
            this.krajnja = krajnja;
            this.pripadaPocetna = pripadaPocetna;
            this.pripadaKrajnja = pripadaKrajnja;
        }
    }

    public Interval() {
        this.pocetna = 0;
        this.krajnja = 0;
        this.pripadaKrajnja = false;
        this.pripadaPocetna = false;
    }

    public boolean isNull() {
        if (this.pocetna == 0 && this.krajnja == 0 && this.pripadaPocetna == false && this.pripadaKrajnja == false)
            return true;
        return false;
    }

    public boolean isIn(double tacka) {
        if (this.pocetna < tacka && this.krajnja > tacka) {
            return true;
        } else if (this.pripadaPocetna == true && tacka == this.pocetna) return true;
        else if (this.pripadaKrajnja == true && tacka == this.krajnja) return true;
        return false;
    }

    public Interval intersect(Interval i) {
        double pocetak = 0, kraj = 0;
        boolean pripadaPocetak = true, pripadaKraj = true;
        if (pocetna > i.pocetna) {
            pocetak = pocetna;
            if (pripadaPocetna == false) pripadaPocetak = false;
        } else {
            pocetak = i.pocetna;
            if (i.pripadaPocetna == false) pripadaPocetak = false;
        }
        if (krajnja < i.krajnja) {
            kraj = krajnja;
            if (pripadaKrajnja == false) pripadaKraj = false;
        } else {
            kraj = i.krajnja;
            if (i.pripadaKrajnja == false) pripadaKraj = false;
        }
        Interval vracam = new Interval(pocetak, kraj, pripadaPocetak, pripadaKraj);
        return vracam;
    }

    public static Interval intersect(Interval i1, Interval i2) {
       return i1.intersect(i2);
    }

    @Override
    public String toString() {
        if (this.isNull()) return "()";
        else if (pripadaPocetna == true && pripadaKrajnja == true && this.isNull() == false) {
            return "[" + pocetna + "," + krajnja + "]";
        } else if (pripadaPocetna == true && pripadaKrajnja == false && this.isNull() == false) {
            return "[" + pocetna + "," + krajnja + ")";
        } else if (pripadaPocetna == false && pripadaKrajnja == true && this.isNull() == false) {
            return "(" + pocetna + "," + krajnja + "]";
        } else
            return "(" + pocetna + "," + krajnja + ")";

    }

    @Override
    public boolean equals(Object o) {
        Interval i = (Interval) o;
        return pocetna == ((Interval) o).pocetna && krajnja == ((Interval) o).krajnja && pripadaPocetna == ((Interval) o).pripadaPocetna && pripadaKrajnja == ((Interval) o).pripadaKrajnja;
    }
}
