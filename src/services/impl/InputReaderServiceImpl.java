package services.impl;

import services.InputReaderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReaderServiceImpl implements InputReaderService {
    @Override
    public int readInput() {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter the desired amount of seconds (positive integer): ");
            int input;
            do {    //I could also use nextLine and write some more custom validations in a separate class.
                input = scanner.nextInt(); //But I think the built-in method has done that for me already.
            } while (input < 0);
            return input;
        }catch (InputMismatchException e){
            System.out.println("Wrong input. Please, try again with a positive whole number!");
            return readInput();
        }catch (Exception ex){
            System.out.println("An unexpected error happened during reading user input:");
            ex.printStackTrace();
            return 0;
        }
    }
}
