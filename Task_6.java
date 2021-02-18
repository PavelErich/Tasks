public class Task_6 {
    public static void main(String[] args){
        System.out.println(ctoa('A'));
        System.out.println(ctoa('m'));
        System.out.println(ctoa('['));
        System.out.println(ctoa('\\'));
    }
    //Функция возвращает значение ASCII переданного в неё
    //символа.
    public static int ctoa(char s){
        //Т.к. функция должна возвращать
        //целое число, то произойдет
        //неявное преобразование типов из char в int (код ASCII)
        return s;
    }
}