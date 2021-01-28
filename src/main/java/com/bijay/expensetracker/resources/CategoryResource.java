package com.bijay.expensetracker.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @GetMapping(value = "")
    public String getAllCategories(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        return "Authenticated! User email: " + email;
    }

}
