public class Task_4 {
    public static void main(String[] args){
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        System.out.println(stripUrlParams("https://edabit.com", new String[]{"b"}));
    }
    //Функция возвращает модифицированную url ссылку
    //Принимает массив параметров, которые нужно проигнорировать (или несколько параметров)
    //                                              String... paramsToTrip)
    public static String stripUrlParams(String str, String[] paramsToTrip){
        String tokens[] = str.split("\\?");
        if(tokens.length == 1) return str;
        //Сразу добавляем левую часть до ? и сам '?'
        String res = tokens[0] + '?';
        //Получим параметры вида a=1 или b=2
        String params[] = tokens[1].split("&");
        //Массив уникальных параметров
        String uniq_p[] = new String[params.length];
        //Массив уникальных значений параметров
        String uniq_v[] = new String[params.length];
        int c = 0;
        for(int i = 0; i < params.length; i++){
            //Разделяем параметр на название параметра и на его значение
            String key_value[] = params[i].split("=");
            int index = indexOf(uniq_p, c, key_value[0]);
            //Если параметр key_value[0] найден в uniq_p, то
            //перезаписываем его значение
            if(index != -1)
                uniq_v[index] = key_value[1];
            //Иначе заносим новый уникальный параметр увеличивая счетчик
            else {
                uniq_p[c] = key_value[0];
                uniq_v[c] = key_value[1];
                c++;
            }
        }
        //Добавляем к результирующей строке все параметры если длина
        //paramsToTrip == 0 или его нет в этом массиве
        for(int i = 0; i < c; i++) {
            if(paramsToTrip == null ||
               indexOf(paramsToTrip, paramsToTrip.length, uniq_p[i]) == -1) {
                res += uniq_p[i] + '=' + uniq_v[i] + '&';
            }
        }
        return res.substring(0, res.length() - 1);
    }
    //Перегрузка функции для не обязательного параметра paramsToTrip
    public static String stripUrlParams(String str){ return stripUrlParams(str, null);}
    //Функция возвращает индекс элемента val в массиве arr размером size, если он есть, иначе -1
    public static int indexOf(String[] arr, int size, String val){
        for(int i = 0; i < size; i++)
            if(arr[i].equals(val))
                return i;
        return -1;
    }
}