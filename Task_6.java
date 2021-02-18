public class Task_6 {
    public static void main(String[] argc){
        System.out.println(same(new int[]{1,3,4,4,4}, new int[]{2,5,7}));
        System.out.println(same(new int[]{9,8,7,6}, new int[]{4,4,3,1}));
        System.out.println(same(new int[]{2}, new int[]{3,3,3,3,3}));
    }
    //Функция, которая возвращает true если кол-во уникальных элементов
    //у двух массивов одинаково, иначе false
    public static boolean same(int[] farr, int[] sarr){
        return countUniqEls(farr) == countUniqEls(sarr);
    }
    //Функция возвращает кол-во уникальных элементов в массиве
    public static int countUniqEls(int[] array){
        //Временной массив для уникальных элементов
        int tmp[] = new int[array.length];
        int count = 0;
        for(int i = 0; i < array.length; i++){
            boolean isFind = false;
            //Проходимся по уже найденым уникальным элементам
            //пока не найдем в нем рассматриваемый array[i]
            for(int j = 0; j < count && !isFind; j++)
                isFind = tmp[j] == array[i];
            //Если не нашли, то значит array[i] новый уникальный элемент
            if(!isFind){
                tmp[count] = array[i];
                count++;
            }
        }
        return count;
    }
}