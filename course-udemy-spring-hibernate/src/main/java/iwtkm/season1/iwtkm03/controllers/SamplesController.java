package iwtkm.season1.iwtkm03.controllers;

import com.google.common.base.Strings;
import iwtkm.season1.iwtkm03.model.AwesomeHuman;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/samples")
public class SamplesController {

  /**
   * todo
   * This stuff will process each and every request for this controller. It will trim all string
   * values and convert empty strings to null.
   * Attention! This stuff works for the only controller it is defined within.
   */
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

  @RequestMapping(value = "/showUsernameForm", method = RequestMethod.GET)
  public String sample01ShowUsernameForm() {
    return "sample/sample01-show-username-form";
  }

  @RequestMapping(value = "/showUserName", method = RequestMethod.GET)
  public String sample01ShowUserName(@ModelAttribute("username") String username) {

    // @ModelAttribute annotation allows not to add Model arg and then call this method
//    model.addAttribute("username", username);

    return "sample/sample01-show-user-name";
  }

  @RequestMapping(value = "/shoutUserName", method = RequestMethod.GET)
  public String sample01ShoutUserName(Model model, HttpServletRequest request) {

    final String username = request.getParameter("username");

    model.addAttribute("username", !Strings.isNullOrEmpty(username) ? username.toUpperCase() : "");

    return "sample/sample01-show-user-name";
  }

  @RequestMapping(value = "/shoutLouderUserName", method = RequestMethod.GET)
  public String sample01ShoutLouderUserName(
      Model model,
      @RequestParam("username") String username) {

    model.addAttribute("username",
        !Strings.isNullOrEmpty(username)
            ? username.toUpperCase() + ", you shouted it THAT loud!"
            : "");

    return "sample/sample01-show-user-name";
  }

  // Awesome people

  @GetMapping("/showAwesomeHumanRegistrationForm")
  public String sample02showAwesomeManRegistrationForm(Model model) {
    model.addAttribute("awesomeHuman", new AwesomeHuman());
    model.addAttribute("skillsOptions", AwesomeHuman.getSkillsMap());
    model.addAttribute("awesomenessLevels", AwesomeHuman.AwesomenessLevel.getValuesMap());
    model.addAttribute("kewlnessItems", AwesomeHuman.KewlnessItem.getValuesMap());

    return "sample/sample02-show-awesome-human-registration-form";
  }

  @PostMapping("/registerAwesomeHuman")
  public String sample02registerAwesomeHuman(
      Model model,
      @Valid @ModelAttribute("awesomeHuman") AwesomeHuman awesomeHuman,
      BindingResult bindingResult) {

    System.out.println("awesomeHuman: " + awesomeHuman);
    if (bindingResult.hasErrors()) {
      System.out.println("Has validation errors");

      // todo this may help to understand which values to i18n
      System.out.println("Binding result: " + bindingResult);

      // todo this has to be here, otherwise u'll get strange FM exception "null/empty options"
      model.addAttribute("skillsOptions", AwesomeHuman.getSkillsMap());
      model.addAttribute("awesomenessLevels", AwesomeHuman.AwesomenessLevel.getValuesMap());
      model.addAttribute("kewlnessItems", AwesomeHuman.KewlnessItem.getValuesMap());
    }

    return !bindingResult.hasErrors()
        ? "sample/sample02-confirm-awesome-human-registration"
        : "sample/sample02-show-awesome-human-registration-form";
  }

}
