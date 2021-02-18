public class Task_1 {
    public static void main(String[] args) {
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
    }

    //Функция возращает кол-во решений в зависимости
    //от квадртаного уравнения.
    public static int solutions(int a, int b, int c) {
        long d = (long)b * b - 4l * a * c;
        if (d > 0) return 2;
        return d == 0 ? 1 : 0;
    }
}