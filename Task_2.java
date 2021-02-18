public class Task_2 {
    public static void main(String[] args){
        System.out.println(triArea(3, 2));
        System.out.println(triArea(7, 4));
        System.out.println(triArea(10, 10));
    }
    //Функция нахождения площади треугольника по
    //его высоте и основанию
    //Формула: S = (height * base) / 2
    public static double triArea(double height, double base){
        return (height * base) / 2.0;
    }
}