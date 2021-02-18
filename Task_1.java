public class Task_1 {
    public static void main(String[] args) {
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));
    }

    //Функция, которая повтоярет каждый символ в строке n раз.
    public static String repeat(String word, int n) {
        String result = "";
        //Пройдемся по каждой букве переданного слова.
        for (int i = 0; i < word.length(); i++)
            //Добавим к result i-ый символ переданного слова n раз.
            for (int j = 0; j < n; j++)
                result += word.charAt(i);
        return result;
    }
}
