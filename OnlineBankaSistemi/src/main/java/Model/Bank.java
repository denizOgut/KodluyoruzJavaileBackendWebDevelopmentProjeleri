package Model;

public class Bank {
    public static void moneyTransfer(User sender, User receiver, int amount) {
        if (sender.getBalance() <= 0 || sender.getBalance() < amount) {
            System.out.println("You can't send money to " + receiver.getName() + " " + receiver.getSurname());
        } else {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
        }
    }

    public static void payCreditCardStatement(User user, int amount) {
        if (user.getCreditCard().equals("true")) {
            user.setBalance(user.getBalance() - amount);
        } else {
            throw new IllegalStateException("Invalid Transaction");
        }
    }

    public static void payLoan(User user, int amount) {
        if (user.getBalance() < amount){
            System.out.println("%15 tax applied to your loan !");
        } else {
            user.setBalance(user.getBalance() - amount);
        }
    }
}
