public class Task_7 {
    public static void main(String[] args) {
        System.out.println(addUpTo(3));
        System.out.println(addUpTo(10));
        System.out.println(addUpTo(7));
    }

    //Возращает сумму всех чисел на промежутке [1, Number].
    public static int addUpTo(int Number) {
        int Sum = 0;
        for (int i = 1; i <= Number; i++)
            Sum += i;

        return Sum;
    }
}
