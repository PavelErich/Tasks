import java.util.Locale;

public class Task_2 {
    public static void main(String[] args){
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("Do"));
        System.out.println(translateWord(""));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Do you think it is going to rain today?"));
    }
    //Функция принимает слово и возвращает перевод этого слова
    public static String translateWord(String word){
        if(word == "") return "";
        //Список строчных и прописных гласных английских букв
        String vowels = "aeiouyAEIOUY";
        //Если слово начинается на гласную
        if(vowels.indexOf(word.charAt(0)) != -1)
            return word + "yay";
        int i = 0;
        //Найдем индекс первой гласной буквы после последовательности
        //согласных
        for(; i < word.length() && isLetter(word.charAt(i))
                && vowels.indexOf(word.charAt(i)) == -1; i++);
        String res = "";
        //Заменим буквы в зависимости от регистра
        for(int j = 0, k = i; k < word.length(); k++, j++) {
            if (word.charAt(j) >= 'A' && word.charAt(j) <= 'Z')
                res += toUpperCase(word.charAt(k));
            else res += toLowerCase(word.charAt(k));
        }
        return res + word.substring(0, i).toLowerCase(Locale.ROOT) + "ay";
    }
    //Функция возвращает true - если передаваемый символ
    //является буквой английского алфавита (в независимости от регистра)
    public static boolean isLetter(char s){
        return (s >= 'a' && s <= 'z') || (s >= 'A' && s <= 'Z');
    }
    //Функция возвращает символ в верхнем регистре, если он
    //является буквой в нижнем регистре
    public static char toUpperCase(char s){
        if(s >= 'a' && s <= 'z') s -= 32;
        return s;
    }
    //Функция возвращает символ в нижнем регистре, если он
    //является буквой в верхнем регистре
    public static char toLowerCase(char s){
        if(s >= 'A' && s <= 'Z') s += 32;
        return s;
    }
    //Функция принимает строку-предложение
    //и возвращает переведенное предложение
    public static String translateSentence(String str){
        //Получим все слова предложения (без знаков препинания)
        String[] words = str.split("\\W+");
        String res = "";
        int j = 0;
        for(int i = 0; i < words.length; i++) {
            //Находим индекс начала слова в исходной строке
            int index = str.indexOf(words[i], j);
            //Обрезаем часть после последнего слова и перед
            //рассматриваемым словом, добавляя переведенное слово
            res += str.substring(j, index) + translateWord(words[i]);
            //Смещаем счетчик, указывающий на первый символ после
            //рассматриваемого слова
            j = index + words[i].length();
        }
        //Возвращаем результат добавляя остаток после последнего слова.
        return res + str.substring(j);
    }
}