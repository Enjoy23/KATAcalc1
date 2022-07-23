import java.util.Arrays;
import java.util.Scanner;


class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {


            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            System.out.println(calc(str));
        }


    }

    public static String calc(String input) throws Exception {
        String[] array = input.split(" ");
        String number1 = array[0];
        String operation = array[1];
        inputCheck(array);

        return convertResult(calculation(convertToArab1(array), operation),number1);


    }

    static void inputCheck(String[] array) throws Exception {
        String[] arabNumArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romNumArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] operationArray = {"+", "-", "*", "/"};
        boolean isArabicNum = ((Arrays.asList(arabNumArray).contains(array[0])) &&
                (Arrays.asList(arabNumArray).contains(array[2])));
        boolean isRomNum = ((Arrays.asList(romNumArray).contains(array[0])) &&
                (Arrays.asList(romNumArray).contains(array[2])));

        if (array.length != 3) {
            throw new Exception("Amount of operands not 3");
        }
        if (!Arrays.asList(operationArray).contains(array[1])) {
            throw new Exception("Operation error");
        }

        if (isArabicNum || isRomNum ) {
        }
        else throw new Exception("Wrong numbers");
    }


    static int[] convertToArab1(String [] array){
        int [] arabicDigits = new int[2];
        String [] romNumArray = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        if ( (Arrays.asList(romNumArray).contains(array[0])) &&
                (Arrays.asList(romNumArray).contains(array[2])) ){
            arabicDigits[0] = Arrays.asList(romNumArray).indexOf(array[0])+1;
            arabicDigits[1] = Arrays.asList(romNumArray).indexOf(array[2])+1;
        }
        if ((!Arrays.asList(romNumArray).contains(array[0])) &&
                (!Arrays.asList(romNumArray).contains(array[2]))){
            arabicDigits[0] = Integer.parseInt(array[0]);
            arabicDigits[1] = Integer.parseInt(array[2]);
        }
        return arabicDigits;
    }

    static int calculation (int [] array, String operation){

        int a = array[0];
        int b = array[1];
        int result = 0;
        switch (operation){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }   return result;

    }

    static String convertResult(int result, String number1) throws Exception{
        String stringResult;
        String [] romNumArray =  {null, "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        if (Arrays.asList(romNumArray).contains(number1)) {
            if (result <= 0) {
                throw new Exception("Rom number <=0");
            }
            stringResult = romNumArray[result];
        } else {
            stringResult = result + "";
        }

        return stringResult;
    }

}





