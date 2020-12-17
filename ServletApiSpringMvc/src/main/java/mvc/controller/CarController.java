package mvc.controller;

import mvc.domain.Car;
import mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author egor.oparin@x5.ru
 */
@Controller
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String first(Model model){
        model.addAttribute("cars", carService.getAll());
        return "index";
    }

    @GetMapping("/form/register")
    public String formRegistration(){
        return "register";
    }

    @PostMapping("/car/remove")
    public String remove(@RequestParam("number") String number){
        Car car = carService.get(number);
        carService.unRegister(car);
        return "redirect:/home";
    }


    @PostMapping("/car/register")
    public String register(@RequestParam("number") String number, @RequestParam("model") String model){
        Car car = new Car(number, model);
        carService.register(car);
        return "redirect:/home";
    }

    @GetMapping("/cars")
    public String getCars (){
        return carService.getAll().toString();
    }



}
