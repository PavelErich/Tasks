public class Task_4 {
    public static void main(String[] args){
        System.out.println(profitableGamble(0.2,50,9));
        System.out.println(profitableGamble(0.9,1,2));
        System.out.println(profitableGamble(0.9,3,2));
    }
    //Функция принимает 3 аргумента типа double
    //prob - кол-во товара
    //prize - цена товара
    //pay - кол-во денег
    //Возвращает true если prob * prize > pay
    //иначе false
    public static boolean profitableGamble(double prob,
                                           double prize,
                                           double pay){
        if(prob * prize > pay)
            return true;
        return false;
    }
}