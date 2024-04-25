package ba.propertydamgerecognition.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class LandingController {

    @GetMapping
    public String getInfo() {
        return "info";
    }
}
