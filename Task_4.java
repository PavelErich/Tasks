public class Task_4 {
    public static void main(String[] args){
        int[] res = cumulativeSum(new int[]{1,2,3});
        print_array(res);
        res = cumulativeSum(new int[]{1,-2,3});
        print_array(res);
        res = cumulativeSum(new int[]{3,3,-2,408,3,3});
        print_array(res);
    }
    //Функция принимает массив целых чисел и возвращает
    //новый массив в котором i-ый элемент сумма самого себя
    //+ всех предыдущих чисел
    public static int[] cumulativeSum(int[] array){
        int sum = 0;
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++){
            result[i] = array[i] + sum;
            sum += array[i];
        }
        return result;
    }
    //Функция вывода массив в консоль
    public static void print_array(int[] array){
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}