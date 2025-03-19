package ma.professional.kitchen.professional_kitchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This will map to login.html
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "2024".equals(password)) {
            return new ModelAndView("redirect:/products"); // Redirect to the product list page
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "Invalid username or password");
        return modelAndView;
    }
}