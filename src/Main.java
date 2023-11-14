import java.util.Scanner;

import Deletes.UserDeletes;
import logs.LogsDeletes;
import validation.validate;

class Bank {
    private double Balance;
    private String Name;
    private String UserName;
    private String Email;
    private String Password;
    private String Lasttran;
    private final Scanner input;

    public Bank() {
        input = new Scanner(System.in);
//        Set a new User Deletes
        this.Balance = 0.0;
        this.Lasttran = "";
        this.Name = UserDeletes.setName();              /* Set Name */
        this.UserName = UserDeletes.setUserName();      /* Set UserName */
        this.Email = UserDeletes.setEmail();            /* Set user Email */
        this.Password = UserDeletes.setPassword();      /* Set user Password */
        LogsDeletes.setLogs("Set a new Password");
        LogsDeletes.setLogs("Account Create Successful");
        System.out.println("Account Create Successful...");
    }

    //    update password function...
    public void updatePassword() {
        System.out.println("Enter your current Password :- ");
        String password = input.next();
        boolean isMach = validate.isMach(password, this.Password);

        while (!isMach) {
            System.out.println("Password is not Mach Please try again...");
            System.out.println("Enter your current Password :- ");
            password = input.next();
            isMach = validate.isMach(password, this.Password);
        }
        this.Password = UserDeletes.setPassword();
        LogsDeletes.setLogs("Update Password");
    }

    //    Check Balance function
    public void CheckBalance() {
        validate.chaekPassword(this.Password);
        LogsDeletes.setLogs("Check Balance");
        System.out.println("Your Balance is :- " + this.Balance + "$");
    }

    //    add money function
    public void addMoney() {
        validate.chaekPassword(this.Password);
        System.out.println("Enter add Amount :- ");
        long addMoney = input.nextLong();
        this.Balance += (double)addMoney;
        LogsDeletes.setLogs("Add Money Successful");
        System.out.println("Add Money Successful...");
        System.out.println("Your Total Balance is :- " + this.Balance + "$");
        this.Lasttran = addMoney + "$ Add Money Successful...";
    }

    //    withdrew money function
    public void withdrewMoney() {
        validate.chaekPassword(this.Password);
        System.out.println("Enter Withdrew Amount :- ");
        long withdrewAmount = input.nextLong();

        if (this.Balance < (double)withdrewAmount) {
            System.out.println("Your Balance is low...");
            System.out.println("Please Add Money...");
            LogsDeletes.setLogs("withdrew Fall");
            this.Lasttran = withdrewAmount + "$ withdrew Fall...";
            return;
        }

        LogsDeletes.setLogs("withdrew Successful");
        this.Balance -= (double)withdrewAmount;
        System.out.println((double)withdrewAmount + "$ Withdrew Successful...");
        System.out.println("Your Total Balance is :- " + this.Balance);
        this.Lasttran = withdrewAmount + "$ Withdrew Successful...";
    }

//    Profile Deletes function
    public void profileDeletes() {
        LogsDeletes.setLogs("Check Profile Deletes");
        System.out.println("Name is :- " + this.Name);
        System.out.println("UserName is :- " + this.UserName);
        System.out.println("Email is :- " + this.Email);
        System.out.println("Password is :- ********");
        System.out.println("Balance is :- " + this.Balance + "$");
        if (! this.Lasttran.isEmpty()) {
            System.out.println("Your Last Transgression is :- " + this.Lasttran);
        }
    }

//    show total options
    public int showOptions() {
        try {
            System.out.println("\n=========== :- Show Options -: ===========\n");
            System.out.println("[1]. Update Password...");
            System.out.println("[2]. Check Balance...");
            System.out.println("[3]. Add Money...");
            System.out.println("[4]. Print Logs...");
            System.out.println("[5]. Withdrew Money...");
            System.out.println("[6]. Profile Deletes...");
            System.out.println("[q]. exit...");
            System.out.print("Enter Your Options :- ");
            char idx = input.next().charAt(0);
            if (idx == 'q') {
                return -1;
            }
            if (idx == '1' || idx == '2' || idx == '3' || idx == '4' || idx == '5' || idx == '6') {
                return idx - '0';
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Invalid input..." + e.toString());
            return -1;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        while (true) {
            int idx = bank.showOptions();
            if (idx == -1) {
                System.out.println("Good bey...");
                break;
            }
            if (idx == 0) {
                System.out.println("Invalid Options...");
                continue;
            }
            switch (idx) {
                case 1:
                    System.out.println("=========== :- Update Password -: ===========");
                    bank.updatePassword();
                    break;
                case 2:
                    System.out.println("=========== :- Check Balance -: ===========");
                    bank.CheckBalance();
                    break;
                case 3:
                    System.out.println("=========== :- Add Money -: ===========");
                    bank.addMoney();
                    break;
                case 4 :
                    System.out.println("================ :- Check Logs -: ================");
                    LogsDeletes.printLogs();
                    break;
                case 5 :
                    System.out.println("=========== :- Withdrew Money -: ===========");
                    bank.withdrewMoney();
                    break;
                case 6 :
                    System.out.println("=========== :- My Profile Deletes -: ===========");
                    bank.profileDeletes();
                    break;
            }
        }
    }
}
