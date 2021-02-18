public class Task_3 {
    public static void main(String[] args){
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(toSnakeCase("getColor"));
    }
    //Функция возвращает строку преобразованную в
    //camelCase стиль написания из snake_case
    public static String toCamelCase(String str){
        int index = str.indexOf('_');
        String res = "";
        int si = 0;
        while(index != -1) {
            res += str.substring(si, index);
            res += (char)(str.charAt(index + 1) - 32);
            si = index + 2;
            index = str.indexOf('_', index + 1);
        }
        res += str.substring(si, str.length());
        return res;
    }
    //Функция возвращает строку преобразованную в
    //snake_case стиль написания из camelCase
    public static String toSnakeCase(String str) {
        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                res += "_" + (char)(str.charAt(i) + 32);
            else res += str.charAt(i);
        }
        return res;
    }
}