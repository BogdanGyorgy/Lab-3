package Problema2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Magazin {
    public static List<Produs> citesteProduseFisier(String numeFisier) throws IOException {
        List<Produs> produse = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] campuri = linie.split(",");  // separa elementele pe baza virgulei
                if (campuri.length == 4) {  // verificam daca avem toate cele 4 elemente
                    String denumire = campuri[0].trim();
                    double pret = Double.parseDouble(campuri[1].trim());
                    int cantitate = Integer.parseInt(campuri[2].trim());
                    LocalDate dataExpirare = LocalDate.parse(campuri[3].trim());
                    produse.add(new Produs(denumire, pret, cantitate, dataExpirare));
                } else {
                    System.out.println("Linia are un format incorect: " + linie);
                }
            }
        }
        return produse;
    }
}
