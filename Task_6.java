public class Task_6 {
    public static void main(String[] args){
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));
    }
    //Функция принимает индекс
    //и возвращает число Фибоначчи по индексу
    //1 1 2 3 5 8 13
    public static int Fibonacci(int index){
        int first = 1, second = 1, tmp;
        for(int i = 1; i < index; i++){
            tmp = second + first;
            first = second;
            second = tmp;
        }
        return second;
    }
}