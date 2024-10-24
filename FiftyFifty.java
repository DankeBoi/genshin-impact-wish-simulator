import java.util.*;

public class FiftyFifty {
    static int limitedChar = 0;
    static int standardChar = 0;
    static int guaranteedChar = 0;
    static int limited5050Char = 0;
    static int totalChar = 0;
    static boolean nextGuaranteed = false;
    public static void main(String args[]) {
        GetParameters();
    }
    public static void GetParameters() {
        Scanner console = new Scanner(System.in);
        System.out.print("How many 50/50's do you want to attempt? ");
        int attempts = console.nextInt();
        System.out.println();
        console.close();
        roll(attempts);
    }
    private static void roll(int attempts) {
        Random truefalse = new Random();
        for (int i = 0; i < attempts; i++) {
            boolean gotLimited = truefalse.nextBoolean();
            if (nextGuaranteed) {
                limitedChar++;
                guaranteedChar++;
                nextGuaranteed = false;
                System.out.println("- LIMITED 5 STAR (guaranteed)");
            }            
            else if (gotLimited) {
                limitedChar++;
                limited5050Char++;
                nextGuaranteed = false;
                System.out.println("- LIMITED 5 STAR (won 50/50)");
            }
            else {
                standardChar++;
                nextGuaranteed = true;
                System.out.println("- STANDARD 5 STAR (lost 50/50)");
            }
        }

        totalChar += attempts;
        System.out.println("\nTotal characters: " + totalChar);
        System.out.println("\nLimited characters: " + limitedChar);
        System.out.println("Limited characters from guarantee: " + guaranteedChar);
        System.out.println("Limited characters from 50/50: " + limited5050Char);
        System.out.println("\nStandard characters: " + standardChar);
        System.out.println("\n");
    }
}
