public class Task_9 {
    public static void main(String[] args){
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));
    }
    //Функция принимает выражение
    //и возвращает true - если оно верно, иначе false
    public static boolean formula(String str){
        //Разделяем строку по =
        String[] tokens = str.split("=");
        //Первое значение с которым будут сравниваться остальные
        int val = 0;
        for(int i = 0; i < tokens.length; i++){
            String[] tmp;
            int sval;
            //Разделяем строку по мат. операциям (если это возможно сохраняем ответ выражения)
            if((tmp = tokens[i].split("\\*")).length == 2)
                sval = Integer.parseInt(tmp[0].trim()) * Integer.parseInt(tmp[1].trim());
            else if((tmp = tokens[i].split("\\+")).length == 2)
                sval = Integer.parseInt(tmp[0].trim()) + Integer.parseInt(tmp[1].trim());
            else if((tmp = tokens[i].split("-")).length == 2)
                sval = Integer.parseInt(tmp[0].trim()) - Integer.parseInt(tmp[1].trim());
            else if((tmp = tokens[i].split("/")).length == 2)
                sval = Integer.parseInt(tmp[0].trim()) / Integer.parseInt(tmp[1].trim());
            else sval = Integer.parseInt(tokens[i].trim());
            if(i != 0 && sval != val) return false;
            if(i == 0) val = sval;
        }
        return true;
    }
}