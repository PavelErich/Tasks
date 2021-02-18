public class Task_9 {
    public static void main(String[] args) {
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
    }

    //Если число составное, то функция возращает следующее простое число.
    //Иначе возращает его самого.
    public static int nextPrime(int num) {
        //Если изначальное число четное, то
        //добавим единицу сделав его нечетным
        if(num % 2 == 0) num++;
        //Т.к. мы уверены, что num нечетное, то будем
        //увеличивать его на 2
        while(!isPrime(num)) num += 2;
        return num;
    }

    //Функция возращает true, если число простое, если же нет, то возращает false.
    public static boolean isPrime(int n){
        if(n == 1) return false;
        //1 2 4 5 10 20 25 50 100
        //100 50 25 20 10 5 4 2 1
        //По примеру выше видно, что после sqrt(n) = 10 делители начинают повторяться.
        double sqrt_n = Math.sqrt(n);
        for(int i = 2; i <= sqrt_n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
