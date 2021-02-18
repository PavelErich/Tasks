public class Task_10 {
    public static void main(String[] args){
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
    }
    //Функция принимает шаг и возвращает кол-во полей
    //на переданном шаге
    public static int boxSeq(int step){
        int res = 0;
        for(int i = 0; i < step; i++) {
            if(i % 2 == 0) res += 3;
            else res -= 1;
        }
        return res;
    }
}