public class Task_4 {
    public static void main(String[] args){
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1,2,3,4,5,6));
    }
    //Функция принимает числа в качестве аргументов
    //И возвращает произведение цифр до тех пор, пока
    //ответ не станет длинной всего в 1 цифру
    public static int sumDigProd(int... numbers){
        int sum = 0;
        //Подсчитываем сумму чисел
        for(int i = 0; i < numbers.length; i++)
            sum += numbers[i];
        if(sum == 0) return 0;
        int res = 1;
        do{
            res = 1;
            //Находим произведение цифр
            while(sum > 0){
                res *= sum % 10;
                sum /= 10;
            }
            sum = res;
        }while(res >= 10);
        return res;
    }
}