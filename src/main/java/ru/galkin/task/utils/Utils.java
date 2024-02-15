package ru.galkin.task.utils;
import org.springframework.stereotype.Component;
import ru.galkin.task.exception.InvalidInputException;

@Component
public class Utils {

    public static String checkInputString(String  inputString){
        String regex = "^[a-zA-Z]*$";

        if(inputString.matches(regex)){
            return inputString.toLowerCase();
        }
        throw new InvalidInputException("Incorrect input");
    }
}
