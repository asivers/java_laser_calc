public class Complex {

    double x = 0;
    double y = 0;

    public Complex(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public Complex sumC(Complex p, Complex q) {
        Complex r = new Complex(0,0);
        r.x = p.x + q.x;
        r.y = p.y + q.y;
        return r;
    }

    public Complex negC(Complex p) {
        Complex r = new Complex(0,0);
        r.x = -p.x;
        r.y = -p.y;
        return r;
    }

    public Complex multC(Complex p, Complex q) {
        Complex r = new Complex(0,0);
        r.x = (p.x * q.x) - (p.y * q.y);
        r.y = (p.y * q.x) + (p.x * q.y);
        return r;
    }

    public Complex divC(Complex p, Complex q) {
        Complex r = new Complex(0,0);
        r.x = (p.x * q.x) + (p.y * q.y);
        r.y = (p.y * q.x) - (p.x * q.y);
        double s = (q.x * q.x) + (q.y * q.y);
        r.x /= s;
        r.y /= s;
        return r;
    }

    public Complex sqrtC(Complex p) {
        Complex r = new Complex(0,0);
        double R = Math.sqrt((p.x * p.x) + (p.y * p.y));
        if (p.x == 0) {
            r.x = 0;
            r.y = Math.sqrt(p.y);
        }
        else {
            double ph = Math.atan(p.y / p.x);
            if (p.x < 0) {
                ph += Math.PI;
            }
            r.x = Math.sqrt(R) * Math.cos(ph / 2);
            r.y = Math.sqrt(R) * Math.sin(ph / 2);
        }
        return r;
    }

}
