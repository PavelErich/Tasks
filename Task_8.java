public class Task_8 {
    public static void main(String[] args){
        System.out.println(nextEdge(8, 10));
        System.out.println(nextEdge(5, 7));
        System.out.println(nextEdge(9, 2));
    }
    //Функция возвращает максимальную целочисленную
    //длину третьей стороны треугольника
    //Принимает длины двух сторон типа int
    public static int nextEdge(int a, int b){
        //Сумма двух сторон должна быть > третьей
        //a + b > c => c = a + b - 1
        return a + b - 1;
    }
}