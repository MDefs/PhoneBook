package com.mdefs.controller;

import com.mdefs.entity.Filter;
import com.mdefs.entity.Phone;
import com.mdefs.entity.User;
import com.mdefs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("newUser")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @ModelAttribute("newUser")
    User getUser() {
        return new User();
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(Model model) {
        model.addAttribute("newUser", new User());

        return "register-form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute("newUser") @Valid User user, BindingResult result) {
        if (userService.findByUsername(user.getUsername()) != null) {
            result.rejectValue("username", "Exist");
            return "register-form";
        }
        if (result.hasErrors()) {
            return "register-form";
        }
        userService.registerUser(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLogin(Model model) {
        model.addAttribute("newUser", new User());

        return "login-user";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String submitLogin(@ModelAttribute("newUser") @Valid User user, BindingResult result) {
        User findUser;
        if (userService.findByUsername(user.getUsername()) != null) {
            findUser = userService.findByUsername(user.getUsername());
            String password = user.getPassword();
            String encodePassword = findUser.getEncodePassword();
            if (passwordEncoder.matches(password, encodePassword)) {
                return "redirect:/welcome";
            }
        }
        result.rejectValue("username", "Wrong");

        return "login-user";
    }


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(@ModelAttribute("newUser") User user, Model model) {
        if (user.getUsername()!=null) {
            model.addAttribute("phoneList", userService.phoneList(user.getUsername()));
            model.addAttribute("newPhone", new Phone());
            model.addAttribute("newFilter", new Filter());

            return "welcome";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("newFilter") Filter filter, @ModelAttribute("newUser") User user) {
        if (filter.getSearchLastName().equals("") && filter.getSearchFirstName().equals("") && filter.getSearchPhone().equals("")) {
            return "redirect:/welcome";
        }
        List<Phone> filteredList = new ArrayList<>();
        for (Phone l: userService.phoneList(user.getUsername())) {
            if (l.getFirstName().contains(filter.getSearchFirstName()) && l.getLastName().contains(filter.getSearchLastName()) && l.getMobilePhone().contains(filter.getSearchPhone())) {

                    filteredList.add(l);
                    System.out.println(l.getFirstName());

            }
        }
        filter.setList(filteredList);

        return "search";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPhone(Model model, @ModelAttribute("newUser") User user) {
        model.addAttribute("newPhone", new Phone());

        return "add-form";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submitWelcome(@ModelAttribute("newPhone") @Valid Phone phone, BindingResult result) {
        if (result.hasErrors()) {
            return "add-form";
        }
        userService.savePhone(phone);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updatePhone(Model model, @PathVariable("id") int id) {
        Phone phone = userService.findPhoneById(id);
        model.addAttribute("newPhone", phone);

        return "edit-form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePhone(@ModelAttribute("newPhone") @Valid Phone phone, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-form";
        }
        userService.updatePhone(phone);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removePhone(@PathVariable("id") int id) {
        Phone phone = userService.findPhoneById(id);
        userService.deletePhone(phone);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
