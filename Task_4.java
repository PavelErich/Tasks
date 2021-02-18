public class Task_4 {
    public static void main(String[] args) {
        System.out.println(overTime(new double[] {9, 17, 30, 1.5}));
        System.out.println(overTime(new double[] {16, 18, 30, 1.8}));
        System.out.println(overTime(new double[] {13.25, 15, 30, 1.5}));
    }

    //Функция высчитывает оплату, связанную с работой.
    public static String overTime(double[] info) {
        double hours = 0;
        double hoursHeight = 0;
        //Кол-во часов без сверхурочных
        if(info[1] <= 17)
            hours = info[1] - info[0];
        //со сверхурочными
        else{
            hours = 17 - info[0];
            hoursHeight = info[1] - 17;
        }
        //Расчет зарплаты за день
        return "$" + String.format("%.2f", info[2] * (hours + hoursHeight * info[3]));
    }
}