public class Task_3 {
    public static void main(String[] args) {
        System.out.println(isAvgWhole(new int[] {1, 3}));
        System.out.println(isAvgWhole(new int[] {1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[] {1, 5, 6}));
        System.out.println(isAvgWhole(new int[] {1, 1, 1}));
        System.out.println(isAvgWhole(new int[] {9, 2, 2, 5}));
    }
    //Функция, которая принимает массив в качестве аргумента и возращает true или false
    //В зависимости от того, является ли средненее значение всех элементов массива целым числом или нет.
    public static boolean isAvgWhole(int[] array) {
        double avg = 0;
        //Цикл суммирует все элементы массива.
        for (int i = 0; i < array.length; i++)
            avg += array[i];
        avg /= array.length; //Среднее знаение.
        //Проверка на целое.
        return avg - (int)avg == 0;
    }
}
