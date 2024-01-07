package ma.dnaengineering.backend.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorExceptions {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleWrongUrl(Exception ex, Model model) {
        // Customize the response for a wrong URL
        model.addAttribute("error", "The requested page was not found");
        return "error";
    }
}
