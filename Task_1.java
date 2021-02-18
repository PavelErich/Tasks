public class Task_1 {
    public static void main(String[] args) {
        System.out.println(remainder(1, 3));
        System.out.println(remainder(3, 4));
        System.out.println(remainder(-9, 45));
        System.out.println(remainder(5, 5));
    }

    //Возразает остаток от операции деления.
    public static int remainder(int firstNum, int secondNum) {
        return firstNum % secondNum;
    }
}