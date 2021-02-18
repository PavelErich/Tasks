public class Task_3 {
    public static void main(String[] args) {
        System.out.println(animals(2, 3, 5));
        System.out.println(animals(1, 2, 3));
        System.out.println(animals(5, 2, 8));
    }

    //Возвращает общее количество ног все животных.
    public static int animals(int chickens, int cows, int pigs) {
        return 2 * chickens + 4 * cows + 4 * pigs;
    }
}
