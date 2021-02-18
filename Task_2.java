public class Task_2 {
    public static void main(String[] args){
        System.out.println(differenceMaxMin(new int[]{10,4,1,4,-10,-50,32,21}));
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19}));
    }
    //Функция принимает массив целых чисел
    //и возвращает разницу между максимальный и минимальным элементом
    public static int differenceMaxMin(int[] array){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //Находим минимальный и максимальный элемент массива
        for(int i = 0; i < array.length; i++){
            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];
        }
        return max - min;
    }
}