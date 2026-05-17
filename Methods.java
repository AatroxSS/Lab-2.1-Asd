public class Methods {

    // Метод середніх прямокутників
    public static double calcRectangles(double a, double b, double h) {
        int n = (int) Math.round((b - a) / h);
        double integral = 0.0;
        for (int i = 0; i < n; i++) {
            double x_mid = a + i * h + h / 2.0;
            integral += Functions.f(x_mid) * h;
        }
        return integral;
    }

    // Метод трапецій
    public static double calcTrapezoids(double a, double b, double h) {
        int n = (int) Math.round((b - a) / h);
        double integral = (Functions.f(a) + Functions.f(b)) / 2.0;
        for (int i = 1; i < n; i++) {
            integral += Functions.f(a + i * h);
        }
        integral *= h;
        return integral;
    }

    // Метод Сімпсона (парабол)
    public static double calcSimpson(double a, double b, double h) {
        int n = (int) Math.round((b - a) / h);
        double integral = Functions.f(a) + Functions.f(b);
        for (int i = 1; i < n; i++) {
            double x_i = a + i * h;
            if (i % 2 == 0) {
                integral += 2 * Functions.f(x_i);
            } else {
                integral += 4 * Functions.f(x_i);
            }
        }
        integral *= (h / 3.0);
        return integral;
    }
}
