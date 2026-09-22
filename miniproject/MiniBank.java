
class BankException extends Exception {

    public BankException(String message) {
        super(message);
    }
}
public class MiniBank {

    public static void main(String[] args) {

        Account a1 = new SavingsAccount("Dhruvi", 100001L, 5000L);
        Account a2 = new SavingsAccount("princee", 100002L, 3000L);

        System.out.println(a1);
        System.out.println(a2);

        System.out.println("Are accounts equal? " + a1.equals(a2));

        Object obj = a1;

        if (obj instanceof Account) {
            System.out.println("Object is an Account");
        }

        Customer c1 = new Customer(
            "Dhruvi",
            "dhruvi@gmail.com",
            "9876543210"
        );

        Customer.Address address =
            new Customer.Address(
                "Main Road",
                "Surat",
                "395001"
            );

        c1.setAddress(address);

        Customer c2 = c1.clone();

        System.out.println("Customer ID: " + c2.getCustomerId());
        System.out.println("City: " + c2.getAddress().getCity());


         System.out.println(
            "Mobile valid: " +
            Validator.isValidMobile("9876543210")
        );

        System.out.println(
            "Mobile valid: " +
            Validator.isValidMobile("12345")
        );

        System.out.println(
            "Email valid: " +
            Validator.isValidEmail("abc@gmail.com")
        );

        System.out.println(
            "Email valid: " +
            Validator.isValidEmail("abc@")
        );

        System.out.println(
            "PAN valid: " +
            Validator.isValidPan("ABCDE1234F")
        );

        System.out.println(
            "PAN valid: " +
            Validator.isValidPan("12345ABCDE")
        );

        System.out.println(
            "IFSC valid: " +
            Validator.isValidIfsc("SBIN0001234")
        );

        System.out.println(
            "IFSC valid: " +
            Validator.isValidIfsc("123456")
        );

        Command command =
            CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("Type: " + command.type());
        System.out.println("Account: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        Account account = new SavingsAccount("Dhruvi", 100003L, 5000L);

        System.out.println(
            StatementFormatter.buildStatement(account)
        );

          Account[] accounts = {
            new SavingsAccount("Dhruvi", 5000, 1000),
            new CurrentAccount("Rahul", 2000, 5000),
            new FixedDepositAccount("Priya", 10000)
        };

        for (Account currentAccount : accounts) {

            System.out.println(
                "Account: " +
                currentAccount.getAccountNumber()
            );

            System.out.println(
                "Interest Rate: " +
                currentAccount.interestRate()
            );

            System.out.println();
        }

                    Account minimumBalanceAccount =
            new SavingsAccount("Dhruvi", 5000, 1000);

                if (minimumBalanceAccount instanceof SavingsAccount savings) {
            System.out.println(
                "Minimum balance account found: " +
                savings.getBalance()
            );
        }
    }
}