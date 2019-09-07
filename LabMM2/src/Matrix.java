public class Matrix {

    Complex a = new Complex(0,0);
    Complex b = new Complex(0,0);
    Complex c = new Complex(0,0);
    Complex d = new Complex(0,0);

    Complex zz1 = new Complex(1,0);
    Complex zz2 = new Complex(2,0);
    Complex zz4 = new Complex(4,0);

    public Matrix(Complex _a, Complex _b, Complex _c, Complex _d) {
        a = _a;
        b = _b;
        c = _c;
        d = _d;
    }

    public Complex detM(Matrix m) {
        Complex det = a.sumC(a.multC(m.a, m.d), a.negC(a.multC(m.b, m.c)));
        return det;
    }

    public Matrix transpM(Matrix m) {
        Matrix r = new Matrix(a,b,c,d);
        r.a = m.a;
        r.b = m.c;
        r.c = m.b;
        r.d = m.d;
        return r;
    }

    public Matrix invM(Matrix m) {
        Complex det = detM(m);
        Matrix r = new Matrix(a,b,c,d);
        r.a = a.divC(m.d, det);
        r.b = a.divC(a.negC(m.b), det);
        r.c = a.divC(a.negC(m.c), det);
        r.d = a.divC(m.a, det);
        return r;
    }

    public Matrix multM(Matrix m, Matrix n) {
        Matrix r = new Matrix(a,b,c,d);
        r.a = a.sumC(a.multC(m.a, n.a), a.multC(m.b, n.c));
        r.b = a.sumC(a.multC(m.a, n.b), a.multC(m.b, n.d));
        r.c = a.sumC(a.multC(m.c, n.a), a.multC(m.d, n.c));
        r.d = a.sumC(a.multC(m.c, n.b), a.multC(m.d, n.d));
        return r;
    }

    public Complex[] eigenvalsM(Matrix m) {
        Complex[] e = new Complex[2];
        Complex a1 = new Complex(1,0);
        Complex b1 = a.sumC(a.negC(m.a), a.negC(m.d));
        Complex c1 = a.sumC(a.multC(m.a, m.d), a.negC(a.multC(m.b, m.c)));
        Complex D = a.sqrtC(a.sumC(a.multC(b1, b1), a.negC(a.multC((a.multC(zz4, a1)), c1))));
        e[0] = a.divC(a.sumC(a.negC(b1), D), a.multC(zz2, a1));
        e[1] = a.divC(a.sumC(a.negC(b1), a.negC(D)), a.multC(zz2, a1));
        return e;
    }

    public Complex[] eigenvecM(Matrix m, Complex p) {
        Complex[] E = new Complex[2];
        Complex V = a.divC(a.sumC(p, a.negC(m.a)), m.b);
        E[0] = a.divC(zz1, a.sqrtC(a.sumC(zz1, a.multC(V, V))));
        E[1] = a.divC(V, a.sqrtC(a.sumC(zz1, a.multC(V, V))));
        return E;
    }

}
