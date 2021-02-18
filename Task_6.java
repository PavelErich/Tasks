public class Task_6 {
    public static void main(String[] args){
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
    }
    //Функция возвращает true - если число является
    //действитеьным номором кредитной карты, иначе false
    public static boolean validateCard(long num){
        String snum = Long.toString(num);
        if(snum.length() < 14 && snum.length() > 19)
            return false;
        long check_digit = num % 10, sum = 0;
        for(int i = snum.length() - 2; i >= 0; i--){
            //Т.к. индексы начинаются с 0, а не 1
            //то * 2 четные позиции
            if(i % 2 == 0){
                long n = (snum.charAt(i) - '0') % 10 * 2;
                if(n >= 10)
                    sum += n % 10 + (n / 10) % 10;
                else sum += n;
            } else sum += snum.charAt(i) - '0';
        }
        return 10 - (sum % 10) == check_digit;
    }
}