public class Task_5 {
    public static void main(String[] args) {
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(15, 11, 11));
    }

    //Функция, которая возращает что нужно сделать с a и b.
    public static String operation(int N, int a, int b) {
        if (a + b == N)
            return "Added";
        if (a - b == N)
            return "Subtracted";
        if (a * b == N)
            return "Multiplication";
        if (a / b == N)
            return "Division";
        return "None";
    }

}
