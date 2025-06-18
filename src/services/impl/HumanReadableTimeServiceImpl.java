package services.impl;

import services.HumanReadableTimeService;
import services.InputReaderService;
import services.SecondToHRTimeConverter;
import util.HumanReadableTimeCacheUtil;

public class HumanReadableTimeServiceImpl implements HumanReadableTimeService {
    /**
     * Normally, such fields would be DI-d. I thought of simply instantiating it there,
     * but that'd tie the field to a specific implementation (even if there's only one for now.)
     */
    private final InputReaderService inputReaderService;
    private final SecondToHRTimeConverter secondToHRTimeConverter;

    public HumanReadableTimeServiceImpl(InputReaderService inputReaderService, SecondToHRTimeConverter secondToHRTimeConverter){
        this.inputReaderService = inputReaderService;
        this.secondToHRTimeConverter = secondToHRTimeConverter;
    }

    /**
     * Quick note for this process: I went through my code, and thought giving a validator class for a >=0 check
     * is too much in this case. In a more complex task where a validator would be required (or even more, different kind of validators),
     * I would create separate interfaces or a generic one (whichever suits the situation better), and let validation happen there.
     * However, since the task itself does not need that many checks, I left the >=0 check at the input reading.
     * I'm aware this is a bit bending the Single Responsibility Principle, but I didn't want to overcomplicate it either.
     */
    @Override
    public String extractTimeFromInput() {
        int input = inputReaderService.readInput();
        return getCachedOrConvertedTime(input);
    }

    private String getCachedOrConvertedTime(int input){
        String cacheContent = HumanReadableTimeCacheUtil.findInCache(input);
        if(cacheContent == null){
            String result = secondToHRTimeConverter.extractHumanReadableTime(input);
            HumanReadableTimeCacheUtil.cache(input, result);
            return result;
        }
        return cacheContent;
    }
}
