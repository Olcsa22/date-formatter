import enums.TimeConstants;
import services.HumanReadableTimeService;
import services.impl.HumanReadableTimeServiceImpl;
import services.impl.InputReaderServiceImpl;
import services.impl.SecondToHRTimeConverterImpl;

import java.util.Scanner;

public class Main {


    /**
     * Here, instead of instantiating the object, I could create a factory for implementations and call that,
     * but currently I have no other implementation for that.
     * I'll try to come up for a different impl if anything comes to mind, so I could use a factory pattern here.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to my input reader!");

        HumanReadableTimeService humanReadableTimeService
                = new HumanReadableTimeServiceImpl(new InputReaderServiceImpl(), new SecondToHRTimeConverterImpl());

        humanReadableTimeService.extractTimeFromInput();


    }
}