package christmas.util;

import java.util.function.Consumer;

public class InputProcessor {
    public static void continueUntilNormalInput(Runnable processInput, Consumer<String> processIfErrorOccur) {
        while (true) {
            try {
                processInput.run();
                break;
            } catch (IllegalArgumentException e) {
                processIfErrorOccur.accept(e.getMessage());
            }
        }
    }
}
