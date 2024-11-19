package Problema1;

public class Parabola {
    private int a;
    private int b ;
    private  int c;
    public Parabola( int a , int b , int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
public double[] varf()
{
    double v1=-b /(2.0*a);
    double v2= ((-b*b+4*a*c)/4.0*a);
    return new double[]{v1,v2};
}

   public   String afiseazaVarf()
    {
        double v1=this.varf()[0] ;
        double v2= this.varf()[1];

        return ("Varful parabolei are coordonatele : " +v1 + " ," +v2 );
    }

    public int getA() {

        return a;
    }

    public int getB() {
            return b;
    }

    public void setC(int c) {
            this.c = c;
    }
@Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }
    public double[] mijloc(Parabola other )
    {
        double [] varf1=this.varf();
        double [] varf2= other.varf();

        double s1= (varf1[0]+varf2[0])/2;
        double s2= (varf1[1]+varf2[1])/2;
        return (new double[]{s1 , s2});
    }
   public  static double[] mijlocSegment(Parabola other, Parabola other1)
    {
        double[] varf1 = other.varf();
        double [] varf2= other1.varf();

        double m1= ( varf1[0] +varf2[0])/2;
        double m2 =( varf1[1]+ varf2[1])/2;
        return (new double[]{m1,m2});
    }

    public double lungimeSegment(Parabola other) {
        double[] varf1 = this.varf();
        double[] varf2 = other.varf();
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }
    public static double lungimeSegmentStatic(Parabola p1, Parabola p2) {
        double[] varf1 = p1.varf();
        double[] varf2 = p2.varf();

        
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }

}
