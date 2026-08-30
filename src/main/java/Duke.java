public class Duke {
    private String commandType;

    public static void main(String[] args) {
        System.out.println("Hello!");
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        commandType = inferCommandType(input);
        return "Duke heard: " + input;
    }

    public String getCommandType() {
        return commandType;
    }

    /**
     * Infers a command type from the first word so reply bubbles can be styled.
     * This starter project has no real command classes.
     */
    private String inferCommandType(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        String command = input.trim().split("\\s+", 2)[0].toLowerCase();
        return switch (command) {
        case "todo", "deadline", "event" -> "AddCommand";
        case "mark", "unmark" -> "ChangeMarkCommand";
        case "delete" -> "DeleteCommand";
        default -> "";
        };
    }
}
