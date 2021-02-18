public class Task_10 {
    public static void main(String[] args) {
        System.out.println(abcmath(42, 5, 10));
        System.out.println(abcmath(5, 2, 1));
        System.out.println(abcmath(1, 2, 3));
    }
    //Функция принимает три аргумента типа int
    //и возвращает true - если a добавленное к себе b раз
    //делится на c, иначе false
    public static boolean abcmath(int a, int b, int c){
        //Из примера видно, что 1344 = 32 * 42, где
        //2 ^ 5 * 42 = 1344
        //2 ^ 5 = ..0100000 = 1 << 5
        return (a * (1 << b)) % c == 0;
    }
}