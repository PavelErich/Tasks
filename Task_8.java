public class Task_8 {
    public static void main(String[] args){
        System.out.println(isStrangePair("ratio","orator"));
        System.out.println(isStrangePair("sparkling","groups"));
        System.out.println(isStrangePair("bush","hubris"));
        System.out.println(isStrangePair("",""));
    }
    //Функция возвращает true - если первый символ fstr == последнему sstr
    //и последний символ fstr == первому sstr
    public static boolean isStrangePair(String fstr, String sstr){
        int f = fstr.length();
        int s = sstr.length();
        //Если две переданные строки пусты
        if(f == 0 && s == 0) return true;
        //Если одна из строки пустая, а другая нет
        if(f == 0 || s == 0) return false;
        return fstr.charAt(0) == sstr.charAt(s - 1) &&
               fstr.charAt(f - 1) == sstr.charAt(0);
    }
}
