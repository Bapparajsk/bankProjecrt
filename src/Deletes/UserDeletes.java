package Deletes;

import logs.LogsDeletes;
import validation.validate;

import java.util.Scanner;

public class UserDeletes {
    static Scanner input = new Scanner(System.in);
    public static String setName() {
        System.out.println("Enter User Name :- ");
        String name = input.nextLine();

        while (name.length() < 3) {
            System.out.println("UserName must be '3' length");
            name = input.next();
        }
        System.out.println("UserName set Successful...");
        LogsDeletes.setLogs("Set a Name - " + name);
        return name;
    }

    public static String setUserName() {
        System.out.println("Enter UserName :- ");
        String username = input.next();

        while (username.length() < 5) {
            System.out.println("UserName must be '5' length");
            username = input.next();
        }
        System.out.println("UserName set Successful...");
        LogsDeletes.setLogs("Set a UserName - " + username);
        return username;
    }

    public static String setEmail() {
        System.out.println("Enter the Valid Email :- ");
        String email = input.next();

        System.out.println("Email set Successful...");
        LogsDeletes.setLogs("Set a email .com");
        return email;
    }
    public static String setPassword() {
        System.out.println("Set a new Password :- ");
        String password = input.next();
        int isvalid = validate.isPassword(password);
        do {
            if (isvalid == 0) {
                System.out.println("do not set is Empty Password:- ");
                password = input.next();
                isvalid = validate.isPassword(password);
            }
            else if (isvalid == 1) {
                System.out.println("Please Password min length in '6' :- ");
                password = input.next();
                isvalid = validate.isPassword(password);
            }
            else if (isvalid == 2) {
                System.out.println("Please Set in 1 number, UpperCase, and one LowerCase :- ");
                password = input.next();
                isvalid = validate.isPassword(password);
            }
        } while (isvalid != -1);

        System.out.println("Password set Successful...");
        return password;
    }
}
