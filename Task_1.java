public class Task_1 {
    public static void main(String[] args){
        print_array(encrypt("Hello"));
        System.out.println(decrypt(new int[]{72,33,-73,84,-12,-3,13,-13,-68}));
        print_array(encrypt("Sunshine"));
    }
    //Функция принимает строку и возвращает
    //закодированное сообщение
    public static int[] encrypt(String str){
        int res[] = new int[str.length()];
        int last = 0;
        for(int i = 0; i < str.length(); last = str.charAt(i), i++)
            res[i] = str.charAt(i) - last;
        return res;
    }
    //Функция принимает закодированное сообщение
    //в виде массива int и возвращает декодированное
    //сообщение
    public static String decrypt(int array[]){
        char[] res = new char[array.length];
        int last = 0;
        for(int i = 0; i < array.length; last += array[i], i++)
            res[i] = (char)(array[i] + last);
        return new String(res);
    }
    //Функция вывода массива в консоль
    public static void print_array(int array[]){
        for(int el : array)
            System.out.print(el + " ");
        System.out.println();
    }
}