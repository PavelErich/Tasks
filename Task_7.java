import java.util.ArrayList;
import java.util.Arrays;
public class Task_7 {
    public static void main(String[] args){
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));
    }
    //Первые двадцать чисел на английском языке
    static final String[] First_20 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    //Десятки на английском языке (десять, двадцать, тридцать и т.д.)
    static final String[] Tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    //Функция принимает число и возвращает
    //это число в виде строки на английском языке
    //от 0 до 999
    private static String numToEng(int num){
        if(num == 0) return "zero";
        return parser(num);
    }
    //Дополнительная функция для numToEng
    private static String parser(int num){
        if(num == 0) return "";
        else if(num < 20)
            return First_20[num] + " ";
        else if(num < 100)
            return Tens[num / 10] + " " + First_20[num % 10];
        else
            return First_20[num / 100] + " hundred " + parser(num % 100);
    }
}