package Calc;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        // создаем массив арабских чисел
        ArrayList<String> arabNumber = new ArrayList<>(10);
            for (int i = 0; i < 10; i++)
            {
                 arabNumber.add(""+(i+1));
            }
        //создаем массив поддерживаемых операций
        ArrayList<String> charlist = new ArrayList<>(4);
        charlist.add("-");
        charlist.add("+");
        charlist.add("*");
        charlist.add("/");

        //создаем сканер
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {

            String Snum1 = "";
            int num1;
            String Snum2 = "";
            int num2;
            int resultForRoman;
            int countNumber = 0;
            String operation = "";

            //вводим выражение

            String rawData = scanner.nextLine();

            //проверяем по символьно
            for (int i = 0; i < rawData.length(); i++) {
                //если символ не пробел и считываем первое число - сложить символ в строку первого числа
                if (rawData.charAt(i) != ' ' & countNumber == 0) {
                    Snum1 += rawData.charAt(i);
                } else if (rawData.charAt(i) != ' ' & countNumber == 1) {
                    operation += rawData.charAt(i);
                } else if (rawData.charAt(i) != ' ' & countNumber == 2) {
                    Snum2 += rawData.charAt(i);
                } else countNumber++;
            }
            System.out.println("count="+countNumber+";");
            System.out.println("num1="+Snum1+";");
            System.out.println("num2="+Snum2+";");
            System.out.println("oper"+operation+";");
            if (countNumber > 1) {
                if (countNumber == 2)
                {
                    System.out.println(arabNumber.contains(Snum1));
                if (arabNumber.contains(Snum1)) {
                    if (arabNumber.contains(Snum2)) {
                        if (charlist.contains(operation)) {
                            num1 = Integer.parseInt(Snum1);
                            num2 = Integer.parseInt(Snum2);

                            switch (operation) {
                                case "*" -> System.out.println(num1 * num2);
                                case "/" -> System.out.println(num1 / num2);
                                case "+" -> System.out.println(num1 + num2);
                                case "-" -> System.out.println(num1 - num2);
                            }
                        }
                        else {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                            }
                        }
                    } else {
                            if (Integer.parseInt(Snum2) > 10)
                            {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                                }
                            }
                            else
                            {
                                try {
                                    throw new Exception();
                                } catch (Exception e) {
                                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                                }
                            }

                    }
                } else if (Roman.contains(Snum1)) {
                    if (Roman.contains(Snum2)) {
                        if (charlist.contains(operation)) {
                            Roman romanOperand1 = Roman.valueOf(Snum1);
                            Roman romanOperand2 = Roman.valueOf(Snum2);
                            num1 = romanOperand1.getFixIndex();
                            num2 = romanOperand2.getFixIndex();

                            switch (operation) {
                                case "*" -> {
                                    resultForRoman = num1 * num2;
                                    System.out.println(DecIntoRoman(resultForRoman));
                                }
                                case "/" -> {
                                    resultForRoman = num1 / num2;
                                    System.out.println(DecIntoRoman(resultForRoman));
                                }
                                case "+" -> {
                                    resultForRoman = num1 + num2;
                                    System.out.println(DecIntoRoman(resultForRoman));
                                }
                                case "-" -> {
                                    resultForRoman = num1 - num2;
                                    if (resultForRoman > 0) {
                                        System.out.println(DecIntoRoman(resultForRoman));
                                    } else {
                                        try {
                                            throw new Exception();
                                        } catch (Exception e) {
                                            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                            }
                        }
                    }
                    else {
                        String char2 = "";
                        char2 += Snum2.charAt(0);
                        if (Snum2.length()>1 & Roman.contains(char2))
                        {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                            }
                        }
                        else
                        {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                            }
                        }
                    }

                }
                    else {
                        String char1 = "";
                        char1 += Snum1.charAt(0);
                        if(Snum1.length()>1 & Roman.contains(char1))
                        {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                            }
                        }
                        else
                        {
                            try {
                                throw new Exception();
                            } catch (Exception e) {
                                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                            }
                        }
                    }

            }
                else
                {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                }

            }
            else
            {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("throws Exception //т.к. строка не является математической операцией");
                }
            }
        }//while(scanner.hasNextLine())
    }//public static void main(String[] args) throws IOException

    public static String DecIntoRoman (int result)
    {
        String resultString = "";

    if (result<=10)
    {
        return Roman.GetStringName(result);
    }
        else if (result<=39)
        {
            int dozen = result / 10;

            for (int i = 0; i < dozen; i++)
            {
                resultString += Roman.GetStringName(10);
            }

            if (result % 10 != 0)
            {
                result = result % 10;
                resultString+=Roman.GetStringName(result);
            }

            return resultString;
        }
            else if (result <= 49)
            {
                int dozen = (result-30) / 10;

                for (int i = 0; i < dozen; i++)
                {
                    resultString += Roman.GetStringName(10);
                }

                resultString+=Roman.GetStringName(50);

                if (result % 10 != 0)
                {
                    result = result % 10;
                    resultString+=Roman.GetStringName(result);
                }

                return resultString;
            }
                else if (result == 50)
                {
                    return Roman.GetStringName(result);
                }
                    else if (result <= 89)
                    {

                        int dozen = (result-50) / 10;

                        resultString+=Roman.GetStringName(50);

                        for (int i = 0; i < dozen; i++) {
                            resultString += Roman.GetStringName(10);
                        }

                        if (result % 10 != 0)
                        {
                            result = result % 10;
                            resultString+=Roman.GetStringName(result);
                        }

                        return resultString;
                    }
                        else if (result <= 99)
                        {
                            System.out.println(result);

                            int dozen = (result-80) / 10;
                            System.out.println(dozen);
                            for (int i = 0; i < dozen; i++) {
                                resultString += Roman.GetStringName(10);
                            }
                            System.out.println(resultString);

                            resultString+=Roman.GetStringName(100);

                            if (result % 10 != 0)
                            {
                                result = 10 - (result % 10);
                                resultString+=Roman.GetStringName(result);
                            }
                            return resultString;
                        }
                            else if (result == 100)
                            {
                                return Roman.GetStringName(100);
                            }
                            return "";
    }
}//public class Main