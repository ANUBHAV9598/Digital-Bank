import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Account[] accounts = new Account[1]; 
        int bankOption, x, currentAccount = 0;
        
        do {
            JOptionPane.showMessageDialog(null, "Welcome to our bank!");
            bankOption = Integer.parseInt(
                    JOptionPane.showInputDialog("Choose an option: \n1 - Create account. \n2 - Search account."));
            
            switch (bankOption) {
                case 1: {
                    for (int i = 0; i < accounts.length; i++) {
                        accounts[i] = new Account();
                        accounts[i].createAccount();
                        accounts[i].setCode(i + 1);
                    }
                    break;
                }
                case 2: {
                    int count = 0;
                    boolean found = true;
                    JOptionPane.showMessageDialog(null, "Search Accounts");
                    String searchName = JOptionPane.showInputDialog("Enter the account name to search:");
                    int accessAccount = Integer.parseInt(JOptionPane.showInputDialog(
                            "What do you want to do? \n1 - View account information \n2 - Access account"));

                    switch (accessAccount) {
                        case 1: {
                            while (found) {
                                if (searchName.equals(accounts[count].getName())) { 
                                    currentAccount = count;
                                    if (accounts[count].getAccountType().equals("Personal Account")) {
                                        JOptionPane.showMessageDialog(null,
                                                "Name: " + accounts[count].getName() + "\nAge: "
                                                        + accounts[count].getAge()
                                                        + "\nCPF: " + accounts[count].getCpf()
                                                        + "\nCode: " + accounts[count].getCode() + "\nAccount Type: "
                                                        + accounts[count].getAccountType() + "\nBalance: "
                                                        + accounts[count].getBalance());
                                    } else if (accounts[count].getAccountType().equals("Business Account")) { 
                                        JOptionPane.showMessageDialog(null,
                                                "Name: " + accounts[count].getName() + "\nAge: "
                                                        + accounts[count].getAge()
                                                        + "\nAccount Type: " + accounts[count].getCnpj()
                                                        + "\nCNPJ: " + accounts[count].getCnpj()
                                                        + "\nCode: " + accounts[count].getCode() + "\nAccount Type: "
                                                        + accounts[count].getAccountType() + "\nBalance: "
                                                        + accounts[count].getBalance());
                                    }
                                    found = false;
                                } else {
                                    count++;
                                }
                            }
                            break;
                        }
                        case 2: {
                            accounts[currentAccount].enterAccount();
                            break;
                        }
                        default:
                            JOptionPane.showMessageDialog(null, "Select one of the options.");
                            break;
                    }
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Select one of these options.");
                    break;
                }
            }
            
            x = Integer.parseInt(JOptionPane.showInputDialog("Do you want to continue? \n0 - Yes; \n1 - No."));
            
        } while (x == 0);
    }
}
