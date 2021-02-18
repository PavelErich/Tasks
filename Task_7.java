public class Task_7 {
    public static void main(String[] args){
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
    }
    //Функция принимает строку
    //и возвращает строку преобразованную в звездную стенографию
    public static String toStarShorthand(String str){
        if(str.length() <= 1) return str;
        //Рассматриваемый символ
        char s = str.charAt(0);
        String res = "";
        int c = 1;
        for(int i = 1; i < str.length(); i++){
            //Если очередной символ == рассматриваемогу то увеличиваем счетчик
            if(str.charAt(i) == s)
                ++c;
            //Если не равен и конец цикла, то добавляем этот символ
            //и если повторений > 1, то добавляем * и кол-во повторений
            //устанавливая c = 1 и новый рассматриваемый символ s
            if(str.charAt(i) != s || i == str.length() - 1){
                res += s;
                if(c > 1) res += "*" + c;
                s = str.charAt(i);
                c = 1;
            }
        }
        //Если предпоследний символ не равен последнему рассматриваемому, то добавляем его
        return res + (str.charAt(str.length() - 2) != s ? s : "");
    }
}