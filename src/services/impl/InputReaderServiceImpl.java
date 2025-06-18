package services.impl;

import services.InputReaderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReaderServiceImpl implements InputReaderService {

    private static final int DEFAULT_RETURN_VALUE = 0;
    private static final Scanner scanner = new Scanner(System.in); //Made it static, so will not produce another instance upon new InputReaderService instance.

    @Override
    public int readInput() {
        int result;
        try {
            result = readWithScanner();
            return result;
        } catch (Exception ex) {
            System.out.println("An unexpected error happened during reading user input:");
            ex.printStackTrace();
            System.out.println("Returning default value (0)...");
            return DEFAULT_RETURN_VALUE;
        }
    }

    /**
     * Note: The scanner is purposefully not closed here. Yes, I could call scanner.close(), or better: use try-with-resources.
     * However, closing a scanner with a System.in stream will close that stream for the whole application lifecycle,
     * making it unusable for future tries.
     *
     */
    private int readWithScanner() {
        int result = -1;
        while (result < 0) {
            System.out.println("Enter the desired amount of seconds (positive integer): ");
            try {
                result = scanner.nextInt();

                if (result < 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Please, try again with a positive whole number!");
                scanner.nextLine(); // Discarding the invalid input here, as it needs to be flushed
            } catch (Exception e){
                System.out.println("An unexpected error happened:");
                e.printStackTrace();
            }
        }
        return result;
    }
}
