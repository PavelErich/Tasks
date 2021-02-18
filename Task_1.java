import java.util.ArrayList;
public class Task_1 {
    public static void main(String[] args){
        String[] res = getStrings(10, 7, "hello my name is Bessie and this is my essay");
        print_array(res);
    }
    //Функция возвращает массив строк, где в каждой новой строке
    //<= k букв. Принимат n - кол-во слов и строку str
    public static String[] getStrings(int n, int k, String str){
        //Список строк
        ArrayList<String> lines = new ArrayList<>();
        //Массив слов
        String[] words = str.split(" ");
        if(n == 0) return null;
        if(words.length != n)
            throw new IllegalArgumentException("Argument 'n' is not equal " +
                    "to the count of words");
        String tmpStr = "";
        int tmpLen = 0;
        for(int i = 0; i < n; i++){
            //Если мы можем добавить к строке слово
            if(words[i].length() + tmpLen <= k){
                tmpStr += words[i] + ' ';
                tmpLen += words[i].length();
            }
            //иначе обрезаем один пробел в конце и добавляем
            //в список строк
            else {
                tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
                lines.add(tmpStr);
                tmpStr = words[i] + ' ';
                tmpLen = words[i].length();
            }
        }
        lines.add(tmpStr.substring(0, tmpStr.length() - 1));
        return lines.toArray(new String[0]);
    }
    //Функция вывода массива строк
    public static void print_array(String[] array){
        if(array != null)
            for(String str : array)
                System.out.println(str);
    }
}