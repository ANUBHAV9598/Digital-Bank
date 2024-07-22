import javax.swing.JOptionPane;

public class Account extends Person {
    public double balance;
    public int code = 0;
    public String accountType;
    public int password;
    public double loan = 0;

    public void createAccount() {
        int count = 0;
        JOptionPane.showMessageDialog(null, "Welcome to the bank! Here, we will create your account.");
        setAge(Integer.parseInt(JOptionPane.showInputDialog("Enter your age: ")));

        if (getAge() >= 18) {
            int choice = Integer.parseInt(JOptionPane
                    .showInputDialog("Choose the type of account you want (1 - Personal Account; 2 - Business Account)"));

            switch (choice) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "You chose the Personal Account type!");
                    setName(JOptionPane.showInputDialog("Enter the account name: "));
                    setPassword(Integer.parseInt(JOptionPane.showInputDialog("Enter the account password: ")));
                    setCpf(JOptionPane.showInputDialog("Enter your CPF: "));
                    setAccountType("Personal Account");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "You chose the Business Account type!");
                    setName(JOptionPane.showInputDialog("Enter the account name: "));
                    setPassword(Integer.parseInt(JOptionPane.showInputDialog("Enter the account password: ")));
                    setCnpj(JOptionPane.showInputDialog("Enter your CNPJ: "));
                    setAccountType("Business Account");
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(null, "Select one of these values!");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Only people aged 18 and above can create an account!");
        }

    }

    public void enterAccount() {
        JOptionPane.showMessageDialog(null, "Enter the account.");
        String name = JOptionPane.showInputDialog(null, "Enter the name of the account you want to access: ");

        if (name.equals(getName())) {
            int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Write what you want to do: "
                    + "\n 1 - Withdraw" + "\n 2 - Make deposit" + "\n 3 - Bank loan" + "\n 4 - Exit"));

            switch (choice) {
                case 1: {
                    withdraw();
                    break;
                }
                case 2: {
                    deposit();
                    break;
                }
                case 3: {
                    loan();
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(null, "You exited the account.");
                    break;
            }
        }

    }

    public double withdraw() {
        JOptionPane.showMessageDialog(null, "Withdraw Page");
        double withdrawAmount = Double.parseDouble(
                JOptionPane.showInputDialog("Enter the amount to withdraw (Limit: 4973):"));
        if (withdrawAmount > 0 && withdrawAmount < 4973) {
            if (!(balance < withdrawAmount)) {
                balance = balance - withdrawAmount;
                JOptionPane.showMessageDialog(null, "Withdraw made successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Unable to withdraw (insufficient balance).");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Unable to withdraw (amount out of limit).");
        }
        return balance;
    }

    public double loan() {
        JOptionPane.showMessageDialog(null, "Loan Page");
        double loanAmount = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter the loan amount you want: (Minimum value: 1500 and Limit: 110500):"));
        if (loanAmount > 1500 && loanAmount < 110500) {
            JOptionPane.showMessageDialog(null, "Loan successfully processed!");
            loan += loanAmount;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid amount!");
        }
        return loan;
    }

    public double deposit() {
        JOptionPane.showMessageDialog(null, "Deposit Page");
        double depositAmount = Double.parseDouble(
                JOptionPane.showInputDialog("Enter the amount to deposit:"));
        balance = balance + depositAmount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

}
