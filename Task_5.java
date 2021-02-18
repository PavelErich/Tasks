import java.util.Locale;

public class Task_5 {
    public static void main(String[] args){
        String[] res = getHashTags("How the Avocado Became the Fruit of the Global Trade");
        print_array(res);
        res = getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year");
        print_array(res);
    }
    //Функция принимает строку с текстом
    //возвращает массив из трех хештегов
    //с максимальными длиннами
    public static String[] getHashTags(String str){
        String[] words = str.split(" ");
        //Массив с максимальными длиннами
        int max[] = new int[]{0,0,0};
        //Индексы слов с максимальными длиннами
        int indexes[] = new int[]{-1,-1,-1};
        for(int i = 0; i < words.length; i++){
            if(max[0] < words[i].length()){
                max[2] = max[1]; indexes[2] = indexes[1];
                max[1] = max[0]; indexes[1] = indexes[0];
                max[0] = words[i].length(); indexes[0] = i;
            } else if(max[1] < words[i].length()){
                max[2] = max[1]; indexes[2] = indexes[1];
                max[1] = words[i].length(); indexes[1] = i;
            } else if(max[2] < words[i].length()){
                max[2] = words[i].length(); indexes[2] = i;
            }
        }
        String[] result = new String[3];
        for(int i = 0; i < result.length; i++)
            result[i] = "#" + words[indexes[i]].toLowerCase();
        return result;
    }
    //Функция вывода массив в консоль
    public static void print_array(String[] array){
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}