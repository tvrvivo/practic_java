package Collections;

public interface ConsoleCommand extends Command {
    /**
     * Горячая клавиша команды;
     * шаблон Command
     *
     * @return символ горячей клавиши
     */
    public char getKey();
}