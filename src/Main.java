import enums.TimeConstants;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my input reader!");
        for(TimeConstants timeConstants : TimeConstants.values()){
            System.out.println(timeConstants.unitName + " - " + timeConstants.inSeconds);
        }
    }
}