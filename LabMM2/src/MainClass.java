public class MainClass {

    public static void main(String args[]) {

        Complex z0 = new Complex(0, 0);
        Complex z1 = new Complex(1, 0);
        Complex z2 = new Complex(2, 0);
        Complex z4 = new Complex(4, 0);
        Complex zPi = new Complex(Math.PI, 0);
        Complex zi = new Complex(0, 1);

        double I0 = 0.1;
        double I = I0;
        double a = 0.1;

        for (int n = 0; n <= 10; n++)
        {
            double zn = 5 + n;
            double Izn = Iout(I0, a, zn);
            //System.out.println(Izn);
        }
    }

    public static double Iout(double _I0, double _a, double _z)
    {
        double Is = 1;
        double rem = 0;
        for (int i = -1000; i <= 1000; i++)
        {
            double ii = i / 1000;
            double gg = Math.log(ii / _I0) + ((_I0 / Is) * ((ii / _I0) - 1)) - (_a * _z);
            System.out.println(gg);
            double c = 100;
            rem = 0;
            if (Math.abs(gg) < c)
            {
                c = Math.abs(gg);
                rem = ii;
            }
        }
        return rem;
    }

}