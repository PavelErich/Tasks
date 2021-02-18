public class Task_8 {
    public static void main(String[] args) {
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
    }

    //Функция, которая возращает true, если две строки рифмуются.
    public static boolean doesRhyme(String firstLine, String secondLine) {
        String lastWordOne = firstLine.substring(firstLine.lastIndexOf(" ") + 1);
        String lastWordTwo = secondLine.substring(secondLine.lastIndexOf(" ") + 1);
        boolean[] hasVowels1 = getVowelsTrue(lastWordOne);
        boolean[] hasVowels2 = getVowelsTrue(lastWordTwo);
        for (int i = 0; i < hasVowels1.length; i++)
            if (hasVowels1[i] != hasVowels2[i])
                return false;
        return true;
    }

    //Функция, которая возращает массив, в котором идет проверка на гласные буквы.
    public static boolean[] getVowelsTrue(String str) {
        String vowels = "AaEeIiOoUuYy";
        boolean[] result = new boolean[vowels.length() / 2];
        for (int i = 0; i < str.length();i++) {
            int index = vowels.indexOf(str.charAt(i));
            if (index != -1)
                result[index / 2] = true;
        }
        return result;
    }
}