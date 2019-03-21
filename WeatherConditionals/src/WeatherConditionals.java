public class WeatherConditionals
{
    public static String getWeatherAdvice(int temperature, String description){
        String string = temperature + " degrees and " + description + ".";
        boolean windy = false;

        if (description == windy && temperature > 30){
            windy = true;
        }



        return hi+""+string;
    }

    public static void main(String[] args){
        System.out.println(WeatherConditionals.getWeatherAdvice(32, "heavy snow"));
    }
}