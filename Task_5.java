public class Task_5 {
    public static void main(String[] args){
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
    }
    //Функция принимает вес в киллограмах или фунтах и высоту в метрах или дюймах.
    //Возвращает строку с индексом массы тела и категорией
    public static String BMI(String weight, String height){
        //val_si разделения на значение и единицу измерения
        String[] val_si = weight.split(" ");
        double d_weight = Double.parseDouble(weight.split(" ")[0]);
        //конвертация из фунтов в киллограмы
        if(val_si[1].equals("pounds")) d_weight /= 2.205;
        val_si = height.split(" ");
        double d_height = Double.parseDouble(val_si[0]);
        //конвертация из дюймов в метры
        if(val_si[1].equals("inches")) d_height /= 39.37;

        //Рассчет индекса массы тела
        double BMI = d_weight / (d_height * d_height);

        //Получение результата
        String res = String.format("%.1f", BMI);
        if(BMI < 18.5) res += " Underweight";
        else if(BMI > 25) res += " Overweight";
        else res += " Normal weight";
        return res;
    }
}