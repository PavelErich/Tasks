public class Task_3 {
    public static void main(String[] args){
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
    }
    //Функция возвращает true если part может быть дополнена до
    //word. Соблюдая порядок букв и без удаления букв в part.
    public static boolean canComplete(String part, String word){
        if(part.length() > word.length()) return false;
        for(int i = 0, last = -1; i < part.length(); i++){
            //Находим вхождение символа part[i] начиная с last + 1
            //если его нет, то или порядок нарушен или такой буквы в word нет
            last = word.indexOf(part.charAt(i), last + 1);
            if(last == -1) return false;
        }
        return true;
    }
}