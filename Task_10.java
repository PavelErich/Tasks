public class Task_10 {
    public static void main(String[] args){
        System.out.println(palindromedescendant(11211230));
        System.out.println(palindromedescendant(13001120));
        System.out.println(palindromedescendant(23336014));
        System.out.println(palindromedescendant(11));
    }
    //Функция принимает целое число типа long
    //и возвращает true - если или число, или его потомки
    //являются палиндромами
    public static boolean palindromedescendant(long num){
        String tmp = Long.toString(num);
        while(tmp.length() > 1) {
            if(isPalindrome(tmp)) return true;
            tmp = "";
            while (num > 0) {
                tmp += Long.toString(num % 10 + num / 10 % 10);
                num /= 100;
            }
            num = Long.parseLong(tmp);
        }
        return false;
    }
    //Функция возвращает true - если строка является
    //палиндромом, иначе false
    public static boolean isPalindrome(String str){
        for(int i = 0; i < str.length() / 2; i++)
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        return true;
    }
}