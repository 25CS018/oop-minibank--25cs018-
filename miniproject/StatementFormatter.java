public class StatementFormatter {

    public static String buildStatement(Account account) {

        StringBuilder sb = new StringBuilder();

        sb.append("----- Account Statement -----\n");
        sb.append("Account Number: ");
        sb.append(account.getAccountNumber());
        sb.append("\n");

        sb.append("Owner: ");
        sb.append(account.getOwnerName());
        sb.append("\n");

        sb.append("Balance: ");
        sb.append(account.getBalance());
        sb.append("\n");

        sb.append("-----------------------------");

        return sb.toString();
    }
}