import java.awt.Color;
import java.util.*;

class ATM {

  String name;
  String userName;
  String password;
  String accountNo;
  float balance = 500000f;
  int transactions = 0;
  String tranHistory = ""; //transaction history

  // to register
  public void register() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter Your Name : ");
    this.name = sc.nextLine();
    System.out.print("\nEnter Your Username : ");
    this.userName = sc.nextLine();
    System.out.print("\nEnter Your Password : ");
    this.password = sc.nextLine();
    System.out.print("\nEnter Your Account Number : ");
    this.accountNo = sc.nextLine();
    System.out.print("\033[32m"); // Green color
    System.out.print("\033[3m"); // Italic font
    System.out.println("\nRegistration completed! *You can Login youself*");
    System.out.print("\033[0m"); // Reset color and font
  }

  // to login
  public boolean login() {
    boolean isLogin = false;
    Scanner sc = new Scanner(System.in);
    while (!isLogin) {
      System.out.print("\nEnter Your Username : ");
      String Username = sc.nextLine();
      if (Username.equals(userName)) {
        while (!isLogin) {
          System.out.print("\nEnter Your Password : ");
          String Password = sc.nextLine();
          if (Password.equals(password)) {
            System.out.print("\033[32m"); // Green color
            System.out.print("\033[3m"); // Italic font
            System.out.print("\nYou have logged in successfully !!");
            System.out.print("\033[0m"); // Reset color and font
            isLogin = true;
          } else {
            System.out.print("\033[31m"); // Red color
            System.out.print("\033[3m"); // Italic font
            System.out.println("\nIncorrect Password !");
            System.out.print("\033[0m"); // Reset color and font
          }
        }
      } else {
        System.out.print("\033[31m"); // Red color
        System.out.print("\033[3m"); // Italic font
        System.out.println("\nInvalid username ! Enter correct username.");
        System.out.print("\033[0m"); // Reset color and font
      }
    }
    return isLogin;
  }

  // to withdraw
  public void withdraw() {
    System.out.print("\nEnter amount to withdraw : ");
    Scanner sc = new Scanner(System.in);
    float amount = sc.nextFloat();
    try {
      if (balance >= amount) {
        transactions++;
        balance -= amount;
        System.out.print("\033[32m"); // Green color
        System.out.print("\033[3m"); // Italic font
        System.out.println("\nWithdraw Successfully !!");
        System.out.print("\033[0m"); // Reset color and font
        String str = amount + " Rs Withdrawed\n";
        tranHistory = tranHistory.concat(str);
      } else {
        System.out.print("\033[31m"); // Red color
        System.out.print("\033[3m"); // Italic font
        System.out.println("\nInsufficient Balance !");
        System.out.print("\033[0m"); // Reset color and font
      }
    } catch (Exception e) {
      System.out.println("Invalid input! " + e.getMessage());
    }
  }

  // to deposit
  public void deposit() {
    System.out.print("\nEnter amount to deposit : ");
    Scanner sc = new Scanner(System.in);
    float amount = sc.nextFloat();

    try {
      if (amount <= 100000f) {
        transactions++;
        balance += amount;
        System.out.print("\033[32m"); // Green color
        System.out.print("\033[3m"); // Italic font
        System.out.println("\nSuccessfully Deposited !!");
        System.out.print("\033[0m"); // Reset color and font
        String str = amount + " Rs deposited\n";
        tranHistory = tranHistory.concat(str);
      } else {
        System.out.print("\033[31m"); // Red color
        System.out.print("\033[3m"); // Italic font
        System.out.println("\nSorry ! Limit is 100000.00");
        System.out.print("\033[0m"); // Reset color and font
      }
    } catch (Exception e) {
      System.out.println("Invalid input! " + e.getMessage());
    }
  }

  // to transfer
  public void transfer() {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter Receipent's Name : ");
    String receipent = sc.nextLine();
    System.out.print("\nEnter amount to transfer : ");
    float amount = sc.nextFloat();

    try {
      if (balance >= amount) {
        if (amount <= 50000f) {
          transactions++;
          balance -= amount;
          System.out.print("\033[32m"); // Green color
          System.out.print("\033[3m"); // Italic font
          System.out.println("\nSuccessfully Transfered to " + receipent);
          System.out.print("\033[0m"); // Reset color and font
          String str = amount + " Rs transfered to " + receipent + "\n";
          tranHistory = tranHistory.concat(str);
        } else {
          System.out.print("\033[31m"); // Red color
          System.out.print("\033[3m"); // Italic font
          System.out.println("\nSorry ! Limit is 50000.00");
          System.out.print("\033[0m"); // Reset color and font
        }
      } else {
        System.out.print("\033[31m"); // Red color
        System.out.print("\033[3m"); // Italic font
        System.out.println("\nYour acconut balance is not sufficient.");
        System.out.print("\033[0m"); // Reset color and font
      }
    } catch (Exception e) {
      System.out.println("Invalid input! " + e.getMessage());
    }
  }

  // to check balance
  public void checkBalance() {
    System.out.println("\n" + balance + " Rs");
  }

  // to show history of transaction
  public void transHistory() {
    if (transactions == 0) {
      System.out.println("\nEmpty");
    } else {
      System.out.println("\n" + tranHistory);
    }
  }
}

public class Task3 {

  // took input must be integer
  public static int takeIntegerInput(int limit) {
    int input = 0;
    boolean flag = false;

    while (!flag) {
      try {
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();
        flag = true;

        if (flag && input > limit || input < 1) {
          System.out.println("Choose the number between 1 to $ : " + limit);
          flag = false;
        }
      } catch (Exception e) {
        System.out.print("\033[31m"); // Red color
        System.out.print("\033[3m"); // Italic font
        System.out.println("Enter only integer value !");
        System.out.print("\033[0m"); // Reset color and font
        flag = false;
      }
    }
    return input;
  }

  public static void main(String[] args) {
    // Set the console text color
    System.out.print("\033[33m"); // Yellow color
    // Set the console text font
    System.out.print("\033[4m"); // Underlined font
    System.out.println("\n WELCOME TO ATM " + "\n");
    // Reset the console color and font
    System.out.print("\033[0m"); // Reset color and font
    System.out.println("1.Haven't you registerd ? Register yourself. \n2.Exit");
    System.out.print("Enter Your Choice : ");
    int choice = takeIntegerInput(2);

    if (choice == 1) {
      ATM b = new ATM();
      b.register();
      while (true) {
        System.out.println("\n1.Login now \n2.Exit");
        System.out.print("Enter Your Choice : ");
        int ch = takeIntegerInput(2);
        if (ch == 1) {
          if (b.login()) {
            // Set the console text color
            System.out.print("\033[33m"); // Yellow color
            // Set the console text font
            System.out.print("\033[4m"); // Underlined font
            System.out.println("\n\n WELCOME " + b.name + "");
            // Reset the console color and font
            System.out.print("\033[0m"); // Reset color and font
            boolean isFinished = false;
            while (!isFinished) {
              System.out.println(
                "\n1.Transaction History \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Check Balance \n6.Exit"
              );
              System.out.print("\nEnter Your Choice : ");
              int c = takeIntegerInput(6);
              switch (c) {
                case 1:
                  b.transHistory();
                  break;
                case 2:
                  b.withdraw();
                  break;
                case 3:
                  b.deposit();
                  break;
                case 4:
                  b.transfer();
                  break;
                case 5:
                  b.checkBalance();
                  break;
                case 6:
                  // Set the console text color
                  System.out.print("\033[33m"); // Yellow color
                  // Set the console text font
                  System.out.print("\033[3m"); // Italic font
                  System.out.println("\nThank you for visit.");
                  System.exit(0);
                  break;
              }
            }
          }
        } else {
          System.exit(0);
        }
      }
    } else {
      System.exit(0);
    }
  }
}
