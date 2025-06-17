package validators.impl;

import validators.InputValidator;

public class InputValidatorImpl implements InputValidator {

    @Override
    public boolean validate(String input) {
        try {
            int value = Integer.parseInt(input);

            return value >= 0;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
