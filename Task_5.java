import java.util.ArrayList;
public class Task_5 {
    public static void main(String[] args){
        print_array(sameVowelGroup(new String[]{"toe", "ocelot", "maniac"}));
        print_array(sameVowelGroup(new String[]{"many", "carriage", "emit", "apricot", "animal"}));
        print_array(sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));
    }
    //Функция возвращает массив слов имеющие все те же гласные
    //как и у первого слова (включая первое слово)
    public static String[] sameVowelGroup(String[] words){
        String vowels = "aeiouy";
        String setVowels = "";
        ArrayList<String> res = new ArrayList<>();
        res.add(words[0]);
        //Заносим в setVowels все гласные, которые есть в 1 слове
        for(int i = 0; i < words[0].length(); i++)
            if(vowels.indexOf(words[0].charAt(i)) != -1)
                setVowels += words[0].charAt(i);
        //Проверем остальные
        for(int i = 1; i < words.length; i++){
            boolean isValid = true;
            for(int j = 0; j < words[i].length() && isValid; j++)
                //Если буква гласная, но её нет в setVowels, то
                //слово не подходит
                if (vowels.indexOf(words[i].charAt(j)) != -1 &&
                    setVowels.indexOf(words[i].charAt(j)) == -1)
                    isValid = false;
            if(isValid) res.add(words[i]);
        }
        return res.toArray(new String[0]);
    }
    //Функция вывода массива в консоль
    public static void print_array(String[] array){
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}