public class palindrome {
    public static void main(String[] args) {
        int num = 121, rev = 0, ori = num;

        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        if (ori == rev)
            System.out.println(ori + " is a Palindrome");
        else
            System.out.println(ori + " is not a Palindrome");
    }
}