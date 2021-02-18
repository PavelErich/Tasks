public class Task_2 {
    public static void main(String[] argc){
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
    }
    //Функция принимает строку и возвращает индекс
    //начала второго вхождения подстроки "zip" в строке str
    public static int findZip(String str){
        int c = 0, j = 0;
        String zip = "zip";
        for(int i = 0; i < str.length(); i++) {
            //Если очередной символ zip = символу строки
            if(zip.charAt(j) == str.charAt(i)) ++j;
            //Если мы нашли подстроку zip в сткроке
            if(j == 3) {
                //Подсчитываем кол-во вхождений
                ++c;
                j = 0;
            }
            //Если мы нашли второе вхождение, то i будет указывать на 'p'
            if(c == 2) return i - 2;
        }
        return -1;
    }
}