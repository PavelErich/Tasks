public class Task_8 {
    public static void main(String[] argc){
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
    }
    //Принимает строку состояющую из 0 и 1
    //и возвращает самую длинную подпоследовательность нулей
    public static String longestZero(String binary){
        int max = 0;
        int size = 0;
        for(int i = 0; i < binary.length(); i++){
            //Подсчитываем длину данной подпоследовательности
            if(binary.charAt(i) == '0')
                ++size;
            //Находим максимальную длину
            if(size > max)
                max = size;
            //Если попали на 1, то обнуляем длину
            if(binary.charAt(i) == '1')
                size = 0;
        }
        //Если не нашли 0, возвращаем пустую строчку
        if(max == 0) return "";
        //Иначе возвращаем max нулей
        return String.format("%1$"+max+"s", "").replace(' ', '0');
    }
}