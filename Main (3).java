package Problema2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Produs> produse = Magazin.citesteProduseFisier("src/Problema2/produse.txt");

        boolean iesire = false;
        while (!iesire) {
            System.out.println("Meniu:");
            System.out.println("1. Afișează toate produsele");
            System.out.println("2. Afișează produsele expirate");
            System.out.println("3. Vinde un produs");
            System.out.println("4. Afișează încasările totale");
            System.out.println("5. Afișează produsele cu prețul minim");
            System.out.println("6. Salvează produsele cu cantitate mai mică decât o valoare");
            System.out.println("7. Ieșire");
            System.out.print("Alege o opțiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1: // afisare produse
                    System.out.println("Produsele din magazin : ");
                    for (Produs produs : produse) {
                        System.out.println(produs);
                    }
                    break;

                case 2: // afisare produse expirate
                    System.out.println("Produsele expirate");
                    boolean existaProduseExpirate = false;
                    for (Produs produs : produse) {
                        if (produs.esteExprirat()) {
                            System.out.println(produs);
                            existaProduseExpirate = true;
                        }
                    }
                    if (!existaProduseExpirate) {
                        System.out.println("Nu exista produse expirate!");
                    }
                    break;

                case 3: // vanzare produs
                    System.out.print("Introdu denumirea produsului: ");
                    String denumireProdus = scanner.nextLine();

                    Produs produsDeVandut = null;
                    for (Produs produs : produse) {
                        if (produs.getDenumire().equalsIgnoreCase(denumireProdus)) {
                            produsDeVandut = produs;
                            break;
                        }
                    }

                    if (produsDeVandut != null) {
                        System.out.print("Introduceti cantitatea de vandut: ");
                        int cantitateVanduta = scanner.nextInt();
                        if (produsDeVandut.vindeProdus(cantitateVanduta)) {
                            if (produsDeVandut.getCantitate() == 0) {
                                produse.remove(produsDeVandut);
                                System.out.println("Produsul " + produsDeVandut.getDenumire() + " a fost eliminat din stoc!");
                            }
                        }
                    } else {
                        System.out.println("Produsul cu denumirea " + denumireProdus + " nu a fost gasit!");
                    }
                    break;

                case 4: // afisare incasari
                    System.out.println("Incasari totale: " + Produs.incasari);
                    break;

                case 5: // produse cu pret minim
                    if (!produse.isEmpty()) {
                        double pretMinim = Double.MAX_VALUE;
                        for (Produs produs : produse) {
                            if (produs.getPret() < pretMinim) {
                                pretMinim = produs.getPret();
                            }
                        }
                        System.out.println("Produsele cu pret minim (" + pretMinim + "):");
                        for (Produs produs : produse) {
                            if (produs.getPret() == pretMinim) {
                                System.out.println(produs);
                            }
                        }
                    } else {
                        System.out.println("Nu exista produse in lista");
                    }
                    break;

                case 6: // salvare produse in fisier cu cantitate mica
                    System.out.print("Introduceti valoarea pentru cantitate minima: ");
                    int cantitateMinima = scanner.nextInt();

                    String fisierIesire = "Produse_sub_cantitate.txt";
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fisierIesire))) {
                        for (Produs produs : produse) {
                            if (produs.getCantitate() < cantitateMinima) {
                                writer.write(produs.toString());
                                writer.newLine();
                            }
                        }
                        System.out.println("Produsele cu cantitate mai mica decat " + cantitateMinima +
                                " au fost salvate in " + fisierIesire);
                    } catch (IOException e) {
                        System.out.println("A aparut o eroare la scrierea in fisier: " + e.getMessage());
                    }
                    break;

                case 7: // iesire
                    iesire = true;
                    System.out.println("La revedere!");
                    break;

                default:
                    System.out.println("Opțiune invalidă! Încearcă din nou.");
            }
        }
    }
}
