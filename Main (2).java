package Problema1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    Parabola p= new Parabola(1,5,7);
    Parabola p1 = new Parabola( 5 ,8 ,1);


   System.out.println(p.afiseazaVarf());
   System.out.println(p1.afiseazaVarf());

        System.out.println(Arrays.toString(p.mijloc(p1)));
        System.out.println(Arrays.toString(Parabola.mijlocSegment(p, p1)));
        System.out.println("Lungimea segmentului dintre vârfuri: " + p.lungimeSegment(p1));
        System.out.println("Lungimea segmentului dintre vârfuri (metodă statică): " + Parabola.lungimeSegmentStatic(p, p1));
    }
}