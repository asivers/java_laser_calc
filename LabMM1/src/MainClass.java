public class MainClass {

    public static void main(String args[]) {

        Complex z0 = new Complex(0,0);
        Complex z1 = new Complex(1,0);
        Complex z2 = new Complex(2,0);
        Complex z4 = new Complex(4,0);
        Complex zPi = new Complex(Math.PI, 0);
        Complex zi = new Complex(0,1);

        //Complex lambda = new Complex(0.00000278,0);
        Complex lambda = new Complex(0.000001,0);

        Complex dar = new Complex(0.0003,0);
        Complex lar = new Complex(0.035,0);
        Complex ni = new Complex(1.92,0);
        Complex Lcav = new Complex(0.12,0);
        Complex Llc = new Complex(0.04,0);

        //Complex dr1 = new Complex(0.2,0);
        //Complex dr2 = new Complex(1.2,0);
        Complex dr1 = new Complex(0,0);
        Complex dr2 = new Complex(0,0);

        //Complex df = new Complex(1,0);
        Complex df = new Complex(0.1,0);
        Complex f = z0.divC(z1, df);

        //Complex x = new Complex(0.4,0);
        Complex x = new Complex(0, 0);

        //Complex d1 = Llc;
        //Complex d2 = z0.sumC(Lcav, z0.negC(Llc));
        Complex d1 = new Complex(0.5,0);
        Complex d2 = new Complex(0.5,0);

        Complex Lx = z0.sumC(z0.sumC(d1, d2), z0.negC(z0.divC((z0.multC(d1, d2)), f)));
        Complex g1 = z0.sumC(z0.sumC(z1, z0.negC(z0.divC(d2, f))), z0.negC(z0.multC(Lx, dr1)));
        Complex g2 = z0.sumC(z0.sumC(z1, z0.negC(z0.divC(d1, f))), z0.negC(z0.multC(Lx, dr2)));
        Complex w1 = z0.sqrtC(z0.multC(z0.divC(z0.multC(lambda, Lx), zPi), z0.sqrtC(z0.divC(g2, z0.multC(g1, z0.sumC(z1, z0.negC(z0.multC(g1,g2))))))));
        Complex w2 = z0.sqrtC(z0.multC(z0.divC(z0.multC(lambda, Lx), zPi), z0.sqrtC(z0.divC(g1, z0.multC(g2, z0.sumC(z1, z0.negC(z0.multC(g1,g2))))))));
        Complex theta = z0.divC(lambda, z0.multC(w2, zPi));
        //это был расчет по пдфке

        Complex Z0 = z0.divC(z1, z0.multC(dr2, z0.sumC(z1, z0.multC(z0.divC(z1, z0.multC(dr2, z0.multC(zPi, z0.multC(w2, z0.divC(w2, lambda))))), z0.divC(z1, z0.multC(dr2, z0.multC(zPi, z0.multC(w2, z0.divC(w2, lambda)))))))));
        Complex w0 = z0.sqrtC(z0.divC(z0.sumC(z0.multC(w2, w2), z0.negC(z0.sqrtC(z0.sumC(z0.multC(z0.multC(w2, w2), z0.multC(w2, w2)), z0.negC(z0.multC(z4, z0.multC(z0.multC(lambda, z0.divC(Z0, zPi)),z0.multC(lambda, z0.divC(Z0, zPi))))))))), z2));
        Complex zR = z0.divC(z0.multC(zPi, z0.multC(w0, w0)), lambda);
        //формулы из прошлогодней лабы, они верны

        Matrix m1d1 = new Matrix(z1,d1,z0,z1);
        Matrix m1d2 = new Matrix(z1,d2,z0,z1);
        Matrix m1x = new Matrix(z1,x,z0,z1);
        Matrix m1d2x = new Matrix(z1,z0.sumC(d2, z0.negC(x)),z0,z1);
        Matrix m2f = new Matrix(z1,z0,z0.negC(z0.divC(z1,f)),z1);
        Matrix m3dr1 = new Matrix(z1,z0,z0.negC(z0.multC(z2,dr1)),z1);
        Matrix m3dr2 = new Matrix(z1,z0,z0.negC(z0.multC(z2,dr2)),z1);
        //задаем матрицы как в файле маткада на фото, они верны

        Matrix mm = m1d1.multM(m1d2x, m1d1.multM(m2f, m1d1.multM(m1d1, m1d1.multM(m3dr1, m1d1.multM(m1d1, m1d1.multM(m2f, m1d1.multM(m1d2, m1d1.multM(m3dr2, m1x))))))));
        System.out.println(mm.a.x);
        System.out.println(mm.a.y);
        System.out.println(mm.b.x);
        System.out.println(mm.b.y);
        System.out.println(mm.c.x);
        System.out.println(mm.c.y);
        System.out.println(mm.d.x);
        System.out.println(mm.d.y);
        System.out.println();

        Complex radius1 = z0.divC(z0.sumC(z0.negC(mm.d), z0.sumC(mm.a, z0.sqrtC(z0.sumC(z0.multC(mm.a, mm.a), z0.sumC(z0.multC(mm.d, mm.d), z0.sumC(z0.multC(z4, z0.multC(mm.b, mm.c)), z0.negC(z0.multC(z2, z0.multC(mm.a, mm.d))))))))), z0.multC(z2, mm.c));
        Complex radius2 = z0.divC(z0.sumC(z0.negC(mm.d), z0.sumC(mm.a, z0.negC(z0.sqrtC(z0.sumC(z0.multC(mm.a, mm.a), z0.sumC(z0.multC(mm.d, mm.d), z0.sumC(z0.multC(z4, z0.multC(mm.b, mm.c)), z0.negC(z0.multC(z2, z0.multC(mm.a, mm.d)))))))))), z0.multC(z2, mm.c));
        System.out.println(radius1.x);
        System.out.println(radius1.y);
        System.out.println(radius2.x);
        System.out.println(radius2.y);
        System.out.println();

        Complex CR1 = z0.divC(z1, radius1);
        Complex ImR1 = new Complex(CR1.y, 0);
        Complex wr1 = z0.sqrtC(z0.multC(z0.divC(lambda, zPi), z0.divC(z1, ImR1)));
        System.out.println(wr1.x);
        System.out.println(wr1.y);
        System.out.println();


        /**
        Matrix mm_1 = m1d1.invM(mm);
        Complex mmDet = m1d1.detM(mm);
        Matrix mmTransp = m1d1.transpM(mm);

        Complex[] GGG = m1d1.eigenvalsM(mm);
        Complex[] HHH = m1d1.eigenvecM(mm, GGG[0]);
        //повторяем как в файле маткада на фото, вплоть до собственных векторов (верно)

        Complex Res1 = z0.multC(g1, g2);
        Complex Res2 = z0.divC(z0.sumC(mm.a, mm.d), z2);
        System.out.println(Res1.x);
        System.out.println(Res1.y);
        System.out.println(Res2.x);
        System.out.println(Res2.y);
        //сравниваем и доказываем что резонатор устойчивый


        //System.out.println(HHH[0].x);
        //System.out.println(HHH[0].y);
        //System.out.println(HHH[1].x);
        //System.out.println(HHH[1].y);
        //System.out.println();
        //Complex B1 = new Complex(0.206,0.689);
        //Complex B2 = new Complex(-0.64,-0.271);
        //System.out.println((z0.divC(HHH[0], HHH[1])).x);
        //System.out.println((z0.divC(HHH[0], HHH[1])).y);
        //System.out.println((z0.divC(B1, B2)).x);
        //System.out.println((z0.divC(B1, B2)).y);
        //доказательство что собственные вектора найдены верно
        */




        /**
        Matrix qMatrix = new Matrix(z1,Z0,z0,z1);
        Complex Q = z0.divC(z0.sumC(z0.multC(qMatrix.a, z0.sumC(Z0, z0.negC(z0.multC(zi, zR)))), qMatrix.b), z0.sumC(z0.multC(qMatrix.c, z0.sumC(Z0, z0.negC(z0.multC(zi, zR)))), qMatrix.d));
        Complex ImQ = new Complex(0, Q.y);
        Complex ReQ = new Complex(Q.x, 0);
        Complex XX1 = z0.divC(ReQ, ImQ);
        Complex XX2 = z0.multC(XX1, XX1);
        Complex XX3 = z0.sumC(z1, XX2);
        Complex XX4 = z0.multC(ImQ, XX3);
        Complex XX5 = z0.multC(XX4, lambda);
        Complex XX6 = z0.divC(XX5, zPi);
        Complex XX7 = z0.negC(XX6);
        Complex XX8 = z0.sqrtC(XX7);
        Complex W = z0.sqrtC(z0.negC(z0.multC(z0.divC(lambda, zPi), z0.multC(ImQ, z0.sumC(z1, z0.multC(z0.divC(ReQ, ImQ), z0.divC(ReQ, ImQ)))))));
        Complex w2x2 = z0.multC(w2, w2);
        System.out.println(w2x2.x);
        System.out.println(w2x2.y);
        System.out.println(XX7.x);
        System.out.println(XX7.y);
         */
        //импровизация с матрицами (№1)

        /**
        //Matrix mm = m1d1.multM(m3dr1,m1d1.multM(m1d1,m1d1.multM(m2f,m1d1.multM(m1d2,m3dr2))));
        Matrix mm = m1d1.multM(m1d2,m1d1.multM(m2f,m1d1));
        //Matrix mm = m1d1.multM(m3dr1,m1d1.multM(m1d1,m1d1.multM(m2f,m1d1.multM(m1d2,m1d1.multM(m3dr2,m1d1.multM(m1d2,m1d1.multM(m2f,m1d1)))))));

        Complex y1 = new Complex(0.00045827,0);
        Complex v1 = new Complex(0.00193,0);

        Complex y2 = z0.sumC(z0.multC(mm.a, y1), z0.multC(mm.b, v1));
        Complex v2 = z0.sumC(z0.multC(mm.c, y1), z0.multC(mm.d, v1));

        System.out.println(y2.x);
        System.out.println(y2.y);
         */
        //импровизация с векторами (№2)

    }

}
