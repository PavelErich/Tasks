public class Task_3 {
    public static void main(String[] args) {
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor("rgb(255,256,255)"));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
    }
    //Функция возвращает true - если переданная строка
    //содерджит валидные значения r,g,b или alpha
    public static boolean validColor(String str) {
        //Разбиваем строку по ','
        String[] tokens = str.split(",");
        boolean res = isValidInt(tokens[0], 0, 255) &&
                      isValidInt(tokens[1], 0, 255) &&
                      isValidInt(tokens[2], 0, 255);
        if(str.charAt(3) == 'a'){
            //Обрезаем закрывающую скобку ')'
            String str_alpha = tokens[3].substring(0, tokens[3].length() - 1);
            if(str_alpha.length() == 0) return false;
            double alpha = Double.valueOf(str_alpha);
            return res && (alpha >= 0 && alpha <= 1);
        }
        return res;
    }
    //Функция возвращает true если первая цифровая подстрока
    //в целочисленном представлении входит в промежуток [min, max]
    public static boolean isValidInt(String str, int min, int max){
        int val = 0, i = 0, s = str.length();
        //Пропускаем все, что не цифры
        while(i < s && str.charAt(i) < '0' && str.charAt(i) > '9')
            i++;
        //Если не нашли ни одну цифру
        if(i == s) return false;
        //Парсим число
        while(i < s && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            val *= 10;
            val += str.charAt(i) - '0';
            i++;
        }
        return val >= min && val <= max;
    }
}