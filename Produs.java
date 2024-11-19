package Problema2;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import  java.time.LocalDate;

public class Produs {
    private String denumire;
    private double pret ;
    private int cantitate;
    private LocalDate dataExpirare;
    public static double incasari=0;

    public Produs(String denumiere , double pret , int cantitate, LocalDate dataExpirare)
    {
        this.denumire=denumiere;
        this.pret=pret  ;
        this.cantitate=cantitate;
        this.dataExpirare=dataExpirare;

    }
    public int getCantitate()
    {
        return cantitate;
    }
    public String getDenumire()
    {
        return denumire;

    }
    public double getPret()
    {
        return pret;
    }

    public boolean esteExprirat()
    {
        return dataExpirare.isBefore(LocalDate.now());
    }

    public boolean vindeProdus(int cantitateVanduta)
    {
        if(cantitateVanduta>cantitate)
        {
            System.out.println("Stoc insuficient pentru produsul "+ denumire + "!");
            return false    ;
        }
        cantitate= cantitate-cantitateVanduta;
        incasari = cantitateVanduta*pret;
        System.out.println("Produsul "+ denumire+" a fost vandut in cantitate de "+ cantitateVanduta);
        return true;
    }
    @Override
    public String toString()
    {
        return "Produs { "+
                "Denumire= "+denumire+
                "Pret =" +pret +
                "Cantitate = " +cantitate +
                "Data expirarii = "+dataExpirare +
                '}';

    }
}
