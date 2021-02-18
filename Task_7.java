public class Task_7 {
    public static void main(String[] args){
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(longestNonrepeatingSubstring("aaaaaa"));
        System.out.println(longestNonrepeatingSubstring("abcde"));
        System.out.println(longestNonrepeatingSubstring("abcda"));
    }
    //Функция принимает строку и возвращает максимально длинную
    //неповторяющиюся подстроку.
    //Сложность алгоритма O(n)
    public static String longestNonrepeatingSubstring(String str){
        //true - если символ уже есть в подпоследовательности, иначе false
        boolean v[] = new boolean[256];
        int maxStart = 0, maxEnd = 0, start = 0, end = 0;
        for(end = 0; end < str.length(); end++){
            //Если символ уже есть в подпоследовательности
            if(v[str.charAt(end)]){
                //То например abcac и когда мы будем на 'c' то мы обнулим символы между
                //первой a и первой c получив подпоследовательность ac
                while (str.charAt(start) != str.charAt(end) && start < end){
                    start++;
                    v[str.charAt(start)] = false;
                }
                start++;
            }
            else {
                v[str.charAt(end)] = true;
                if(end - start > maxEnd - maxStart){
                    maxStart = start;
                    maxEnd = end;
                }
            }
        }
        return str.substring(maxStart, maxEnd + 1 - maxStart);
    }
}