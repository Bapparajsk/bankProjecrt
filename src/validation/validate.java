package validation;

import java.util.Objects;
import java.util.Scanner;

public class validate {
    static Scanner input = new Scanner(System.in);
     public static int isPassword(String password) {
        if (password.isEmpty()) {
            return 0;
        }

        if (password.length() < 6) {
            return 1;
        }

        boolean num = false;
        boolean lower = false;
        boolean upper = false;

        int i = 0;
        int n = password.length();
        while (i < n) {
            if (Character.isDigit(password.charAt(i))) {
                num = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                upper = true;
            }

            if (Character.isLowerCase(password.charAt(i))) {
                lower = true;
            }
            i++;
        }

        return (num && upper && lower) ? -1 : 2;
    }

    public static boolean isMach(String pass1, String pass2) {
         if (pass1.length() != pass2.length()) {
             return false;
         }

         int i = 0;
         int n = pass2.length();

         while (i < n) {
             if (!Objects.equals(pass1.charAt(i), pass2.charAt(i))) {
                 return false;
             }
             i++;
         }

         return true;
    }

    public static void chaekPassword(String password) {
        System.out.println("Enter your Password :- ");
        boolean isMach = validate.isMach(input.next(), password);

        while (!isMach) {
            System.out.println("Invalid Password try again...");
            isMach = validate.isMach(input.next(), password);
        }
    }
}
