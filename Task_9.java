public class Task_9 {
    public static void main(String[] args){
        System.out.println(trouble(451999277L, 41177722899L));
        System.out.println(trouble(1222345L, 12345L));
        System.out.println(trouble(666789L, 12345667));
        System.out.println(trouble(33789L, 12345337L));
    }
    //Функция возвращает true, если
    //в num1 любая цифра повторяется 3 раза подряд, а в
    //num2 два раза подряд
    public static boolean trouble(long num1, long num2){
        return isValid(num1, 3) && isValid(num2, 2);
    }
    //Функция возвращает true если в числе
    //любая цифра повторяется count раз подряд
    public static boolean isValid(long num, int count){
        long c = 1, prevD = -1, digit = 0;
        while(num > 0){
            digit = num % 10;
            if(digit == prevD) ++c;
            else {
                prevD = digit;
                c = 1;
            }
            if(c == count) return true;
            num /= 10;
        }
        return false;
    }
}