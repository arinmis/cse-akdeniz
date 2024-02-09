public class Program {

    public static void main(String[] args) {
        printChars('B');
        System.out.println(getChars('G', ""));
    }

    public  static void printChars(char chr) {
        if (chr >= 'Z' + 1) {
            System.out.println();
            return;
        }
        System.out.print(chr);
        printChars((char)(chr + 1));
    }

    public  static String getChars(char chr, String result) {
        if (chr >= 'Z' + 1)
            return result;
        result += chr;
        return getChars((char)(chr + 1), result);
    }

}
