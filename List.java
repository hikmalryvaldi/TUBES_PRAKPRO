package TUBES;

public class List {

    Nasabah head;

    public void addNasabahHead(String nama, int noRekening, double saldo) {
        Nasabah newNasabah = new Nasabah(nama, noRekening, saldo);
        newNasabah.setNext(head);
        head = newNasabah;
    }

    public void addNasabahMid(String nama, int noRekening, double saldo, int position) {
        Nasabah newNasabah = new Nasabah(nama, noRekening, saldo);
        if (head == null) {
            head = newNasabah;
        } else {
            Nasabah curNode = head;
            if (position == 1) {
                System.out.println("Data tidak bisa ditambahkan");
                newNasabah.setNext(curNode);
            } else {
                Nasabah posNode = null;
                int i = 1;
                while (curNode != null && i < position) {
                    posNode = curNode;
                    curNode = curNode.getNext();
                    i++;
                }
                if (posNode != null) {
                    System.out.println("Data berhasil ditambahkan");
                    posNode.setNext(newNasabah);
                    newNasabah.setNext(curNode);
                }
            }
        }
    }

    public void addNasabahTail(String nama, int noRekening, double saldo) {
        Nasabah newNasabah = new Nasabah(nama, noRekening, saldo);
        if (isEmpty()) {
            head = newNasabah;
        } else {
            Nasabah curNode = head;
            Nasabah posNode = null;

            while (curNode != null) {
                posNode = curNode;
                curNode = curNode.getNext();
            }
            if (posNode != null) {
                posNode.setNext(newNasabah);
            }
        }
    }

    public void hapusNasabah(String nama) {
        if (head == null) {
            System.out.println("List nasabah kosong.");
            return;
        }
        Nasabah curNode = head;
        Nasabah prevNode = null;
        while (curNode != null) {
            if (curNode.getNama().equals(nama)) {
                if (prevNode == null) {
                    head = curNode.getNext();
                } else {
                    prevNode.setNext(curNode.getNext());
                }
                System.out.println("Nasabah dengan nama " + nama + " berhasil dihapus.");
                return;
            }
            prevNode = curNode;
            curNode = curNode.getNext();
        }
        System.out.println("Nasabah dengan nama " + nama + " tidak ditemukan.");
    }

    public Nasabah cariNasabah(String nama) {
        Nasabah curNode = head;
        while (curNode != null && !curNode.getNama().equals(nama)) {
            curNode = curNode.next;
        }
        return curNode;
    }

    public void tampilkanSemua() {
        Nasabah curNode = head;
        while (curNode != null) {
            System.out.println("Nama: " + curNode.getNama() + ", No Rekening: " + curNode.getNoRekening() + ", Saldo: " + curNode.getSaldo());
            curNode = curNode.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

}
