public class Task_8 {
    public static void main(String[] args){
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));
    }
    static String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL",
                                "L", "XC", "C", "CD", "D", "CM", "M"};
    static int[] arabs = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
    //Функция принимает целое число и возвращает
    //его в римском представлении
    public static String convertToRoman(int num){
        String res = "";
        int index = arabs.length;
        while(num > 0){
            //Получаем индекс элемента >= num
            index = lower_bound(arabs, 0, index, num);
            //Т.к. если такого элемента нет в массиве или
            //или найдет элемент > num, то вернемся назад
            //на 1 индекс, чтобы перейти к элементу <= num
            if(index >= arabs.length || arabs[index] > num) index--;
            num -= arabs[index];
            res += romans[index];
        }
        return res;
    }
    //Функция возвращает индекс элемента, который >= val в массиве arr
    //на промежутке от left, до right. Если такого элемента нет, то возвращается
    //right
    private static int lower_bound(int[] arr, int left, int right, int val){
        int mid;
        //Используется алгоритм бинарного поиска
        while(left < right){
            mid = left + (right - left) / 2;
            if(val > arr[mid])
                left = mid + 1;
            else right = mid;
        }
        return left;
    }
}