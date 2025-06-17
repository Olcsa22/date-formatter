package enums;

public enum TimeConstants {
    YEAR(31536000, "year"),
    DAY(86400, "day"),
    HOUR(3600, "hour"),
    MINUTE(60, "minute"),
    SECOND(1, "second");

    public final int inSeconds;
    public final String unitName;

    private TimeConstants(int inSeconds, String unitName){
        this.inSeconds = inSeconds;
        this.unitName = unitName;
    }
}
