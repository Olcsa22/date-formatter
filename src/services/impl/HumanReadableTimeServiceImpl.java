package services.impl;

import services.HumanReadableTimeService;
import services.InputReaderService;
import validators.InputValidator;

public class HumanReadableTimeServiceImpl implements HumanReadableTimeService {
    /**
     * Normally, such fields would be DI-d. I thought of simply instantiating it there,
     * but that'd tie the field to a specific implementation (even if there's only one for now.)
     */
    private InputReaderService inputReaderService;
    private InputValidator inputValidator;

    public HumanReadableTimeServiceImpl(InputReaderService inputReaderService, InputValidator inputValidator){
        this.inputReaderService = inputReaderService;
        this.inputValidator = inputValidator;
    }

    @Override
    public void extractTimeFromInput() {
        int input = inputReaderService.readInput();

    }
}
