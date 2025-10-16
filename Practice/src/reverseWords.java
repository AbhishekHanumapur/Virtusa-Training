public class reverseWords {
    public static void main(String[] args) {
        String sentence = "Java is fun";
        String[] words = sentence.split(" ");
        String reversed = "";

        for (int i = words.length - 1; i >= 0; i--) {
            reversed += words[i] + " ";
        }

        System.out.println("Reversed sentence: " + reversed.trim());
    }
}