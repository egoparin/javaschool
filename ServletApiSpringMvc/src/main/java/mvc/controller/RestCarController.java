package mvc.controller;

import mvc.domain.Car;
import mvc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author egor.oparin@x5.ru
 */
@RestController
public class RestCarController {

    @Autowired
    CarService service;

    @GetMapping("/car2/{number}")
    @ResponseBody
    public ResponseEntity<Car> getCar (@PathVariable("number") String number){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responce some", "RestController");
        return ResponseEntity.accepted().headers(headers).body(service.get(number));
    }

}
