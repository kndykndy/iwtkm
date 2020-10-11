package iwtkm.season1.iwtkm03.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * H
 */
@Controller
public class HomeController {

  @RequestMapping(value = {"/", "/index"})
  public String showIndexPage() {
    return "index";
  }

}
