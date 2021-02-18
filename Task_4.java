public class Task_4 {
    public static void main(String[] argc){
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
    }
    //Функция принимает строку и возвращает измененную строку
    //или "Incompatible" если длина строки < 2 или "Two's a pair"
    //если первый и последний символ строки равны
    public static String flipEndChars(String str){
        if(str.length() < 2) return "Incompatible.";
        if(str.charAt(0) == str.charAt(str.length() - 1))
            return "Two's a pair.";
        String result = "";
        //Добавляем последний символ строки
        result += str.charAt(str.length() - 1);
        //Добавляем всю строку без первого и последнего символа
        result += str.substring(1, str.length() - 1);
        //Добавляем первый символ строки
        result += str.charAt(0);
        return result;
    }
}