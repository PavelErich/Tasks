public class Task_6 {
    public static void main(String[] args) {
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
    }

    //Функция возращает мультипликативное постояноство.
    public static int bugger(int num) {
        int result = 1;
        int count = 0;
        for (; num >= 10; count++) {
            for (; num > 0; num /= 10)
                result *= num % 10;
            num = result;
            result = 1;
        }
        return count;
    }
}
