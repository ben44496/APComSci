public class StringTester {
    static String weatherCondition = "tornado";

    static String weatherCondition1 = new String("mixed rain and snow");
    static String weatherCondition2 = new String("mixed rain and snow");
    static boolean result1 = (weatherCondition1 == weatherCondition2);
    static boolean result2 = (weatherCondition1.equals(weatherCondition2));

    public static void main(String[] args){
        System.out.println(weatherCondition.length());
        firstWord("heavy snow");
        System.out.println(result1);

    }

    private static void firstWord(String condition){
        int a = condition.indexOf(" ");
        String fWord = condition.substring(0, a);
        System.out.println(fWord);
    }



}
