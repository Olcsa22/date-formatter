package services.impl;

import enums.TimeConstants;
import services.SecondToHRTimeConverter;

public class SecondToHRTimeConverterImpl implements SecondToHRTimeConverter {

    StringBuilder readableTimeBuilder = new StringBuilder();

    @Override
    public void extractHumanReadableTime(int seconds) {
        for(TimeConstants timeUnit : TimeConstants.values()){
            int count = Math.floorDiv(seconds, timeUnit.inSeconds);
            if(count>0){
                seconds -= count*timeUnit.inSeconds;
                appendTime(timeUnit, count, seconds==0);
            }
        }

        System.out.println(readableTimeBuilder.toString());
    }

    private void appendTime(TimeConstants timeUnit, int amount, boolean end){
        if(end && !readableTimeBuilder.isEmpty()){
            readableTimeBuilder.append("and ");
        }
        readableTimeBuilder.append(amount)
                .append(" ")
                .append(timeUnit.unitName);

        if(amount>1){
            readableTimeBuilder.append('s');
        }
        if(!end){
            readableTimeBuilder.append(", ");
        }
    }
}
