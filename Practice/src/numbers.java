public class numbers {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 50) {
            i++;


            if (i % 2 != 0) {
                continue;
            }


            if (i > 50) {
                break;
            }

            System.out.println(i);
        }
    }
}