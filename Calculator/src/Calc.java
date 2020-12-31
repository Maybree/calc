import java.util.Scanner;
public class Calc {
    public static void main(String[] args) throws Exception {
        String num1, num2;
        int num1i, num2i;
        boolean romanMaths;
        int ans;
        String romanAns;
        char op;
        Scanner reader = new Scanner(System.in);
        num1 = reader.next();
        op = reader.next().charAt(0);
        num2 = reader.next();

        // проверка типов чисел
        NumberOps NumberOps = new NumberOps();
        if (!(NumberOps.isRoman(num1) == NumberOps.isRoman(num2))) {
            throw new Exception("Недопустимый формат данных.");
        }

        // приведение к числовому типу
        if (NumberOps.isRoman(num1)) {
            num1i = NumberOps.ConvertRomanToInt(num1);
            num2i = NumberOps.ConvertRomanToInt(num2);
            romanMaths = true;
        }else{
            num1i = NumberOps.ConvertArabicToInt(num1);
            num2i = NumberOps.ConvertArabicToInt(num2);
            romanMaths = false;
        }

        // проверка входных данных на условия
        if (!((1 <= num1i && num1i <= 10) && (1 <= num2i && num1i <= 10))) {
            throw new Exception("Входные данные вне диапазона доступных значений.");
        }

        // вычисление
        switch(op) {
            case '+': ans = num1i + num2i;
                break;
            case '-': ans = num1i - num2i;
                break;
            case '*': ans = num1i * num2i;
                break;
            case '/': ans = num1i / num2i;
                break;
            default:  System.out.printf("Ошибка! Оператор не распознан.");
                return;
        }

        // если нужно - приведение обратнно в роман
        if (romanMaths){
            romanAns = NumberOps.ConvertToRoman(ans);
            System.out.println(romanAns);
        }
        else {
            System.out.print(ans);
        }


    }
}

