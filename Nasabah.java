package TUBES;

public class Nasabah {
    String nama;
    int noRekening;
    double saldo;
    Nasabah next;

    public Nasabah(String nama, int noRekening, double saldo) {
        this.nama = nama;
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.next = null;
    }

    public String getNama() {
        return nama;
    }

    public int getNoRekening() {
        return noRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public Nasabah getNext() {
        return next;
    }

    public void setNext(Nasabah next) {
        this.next = next;
    }
}
