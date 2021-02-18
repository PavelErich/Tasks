import java.util.Locale;

public class Task_9 {
    public static void main(String[] args){
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
    }
    //Функция возвращает строку с правильным регистром
    //для заголовков
    public static String correctTitle(String str){
        String[] words = str.split(" ");
        String res = "";
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].toLowerCase();
            if(words[i].equals("and")  ||
               words[i].equals("the") ||
               words[i].equals("of")  ||
               words[i].equals("in")) {
                res += words[i];
            }
            //Если в слове есть дефис
            else if(words[i].indexOf('-') != -1){
                String[] tmp = words[i].split("-");
                res += setUpperCaseFS(tmp[0]) + "-" + setUpperCaseFS(tmp[1]);
            }
            //Если нет дефиса и не является and, the, of, in
            else res += setUpperCaseFS(words[i]);
            if(i < words.length - 1) res += " ";
        }
        return res;
    }
    //Функция возвращает строку
    //с первым символом в верхнем регистре
    public static String setUpperCaseFS(String str){
        return str.substring(0, 1).toUpperCase() +
               str.substring(1, str.length());
    }
}