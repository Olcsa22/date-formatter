package services.impl;

import enums.TimeConstants;
import services.SecondToHRTimeConverter;

public class SecondToHRTimeConverterImpl implements SecondToHRTimeConverter {


    /**
     * Used a StringBuilder, as it adds only one string to our string pool, so it's more memory-efficient
     * instead of using string concatenations
     */
    @Override
    public String extractHumanReadableTime(int seconds) {
        StringBuilder readableTimeBuilder = new StringBuilder();

        for(TimeConstants timeUnit : TimeConstants.values()){
            int count = Math.floorDiv(seconds, timeUnit.inSeconds);
            if(count>0){
                seconds -= count*timeUnit.inSeconds;
                appendTime(readableTimeBuilder, timeUnit, count, seconds==0);
            }
        }

        checkForEmpty(readableTimeBuilder);
        return readableTimeBuilder.toString();
    }

    private void checkForEmpty(StringBuilder readableTimeBuilder) {
        if(readableTimeBuilder.isEmpty()){
            readableTimeBuilder.append("now");
        }
    }

    private void appendTime(StringBuilder readableTimeBuilder, TimeConstants timeUnit, int amount, boolean lastUnit){
        if(!lastUnit && !readableTimeBuilder.isEmpty()){
            readableTimeBuilder.append(", ");
        }
        if(lastUnit && !readableTimeBuilder.isEmpty()){
            readableTimeBuilder.append(" and ");
        }
        readableTimeBuilder.append(amount)
                .append(" ")
                .append(timeUnit.unitName);

        if(amount>1){
            readableTimeBuilder.append('s');
        }
    }
}
