import java.util.Scanner;

public class Main {

    private static double getExactValue(double a, double b) {
        return Methods.calcSimpson(a, b, 0.00001);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Завдання першого рівня. Варіант 3 ---");

        double a = 0.0;
        double b = 3.0;
        double h = 0.5;

        try {
            System.out.print("Введіть початок інтервалу a (Enter для 0): ");
            String aInput = scanner.nextLine().replace(",", ".");
            if (!aInput.trim().isEmpty()) a = Double.parseDouble(aInput);

            System.out.print("Введіть кінець інтервалу b (Enter для 3): ");
            String bInput = scanner.nextLine().replace(",", ".");
            if (!bInput.trim().isEmpty()) b = Double.parseDouble(bInput);

            System.out.print("Введіть крок h (Enter для 0.5): ");
            String hInput = scanner.nextLine().replace(",", ".");
            if (!hInput.trim().isEmpty()) h = Double.parseDouble(hInput);

        } catch (NumberFormatException e) {
            System.out.println("Помилка вводу. Використовуються значення за замовчуванням: a=0, b=3, h=0.5");
            a = 0.0;
            b = 3.0;
            h = 0.5;
        }

        int n = (int) Math.round((b - a) / h);
        if (n % 2 != 0) {
            System.out.printf("\n[Увага] Для точної роботи методу Сімпсона кількість відрізків (поточна n=%d) має бути парною!\n", n);
        }

        double exactVal = getExactValue(a, b);

        double rectVal = Methods.calcRectangles(a, b, h);
        double trapVal = Methods.calcTrapezoids(a, b, h);
        double simpVal = Methods.calcSimpson(a, b, h);

        System.out.printf("\n--- Результати обчислень на інтервалі [%.1f, %.1f] з кроком h=%.1f ---\n", a, b, h);
        System.out.printf("Точне (еталонне) значення: %.8f\n", exactVal);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-25s | %-15s | %s\n", "Метод", "Значення", "Абсолютна похибка");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-25s | %-15.8f | %.8f\n", "Метод прямокутників", rectVal, Math.abs(exactVal - rectVal));
        System.out.printf("%-25s | %-15.8f | %.8f\n", "Метод трапецій", trapVal, Math.abs(exactVal - trapVal));
        System.out.printf("%-25s | %-15.8f | %.8f\n", "Метод Сімпсона", simpVal, Math.abs(exactVal - simpVal));

        scanner.close();
    }
}
