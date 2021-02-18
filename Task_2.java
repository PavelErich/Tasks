import java.util.ArrayList;
public class Task_2 {
    public static void main(String[] args){
        print_array(split("()()()"));
        print_array(split("((()))"));
        print_array(split("((()))(())()()(()())"));
        print_array(split("((())())(()(()()))"));
    }
    //Функция групирует строку в кластер скобок
    //Принимает строку с веденным скобками
    //Возвращает массив строк
    public static String[] split(String str){
        int bracket = 0, prevI = 0;
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') bracket++;
            else if(str.charAt(i) == ')') bracket--;
            //Если кол-во открывающих == кол-во закрывающих
            //скобок, то мы нашли кластер
            if(bracket == 0){
                res.add(str.substring(prevI, i + 1));
                prevI = i + 1;
            }
        }
        return res.toArray(new String[0]);
    }
    //Функция вывода массива строк
    public static void print_array(String[] array){
        System.out.print("[");
        for(int i = 0; i < array.length - 1; i++)
            System.out.print("\"" + array[i] + "\", ");
        System.out.println("\"" + array[array.length - 1] + "\"]");
    }
}