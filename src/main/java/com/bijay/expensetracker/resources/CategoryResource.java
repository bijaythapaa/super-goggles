package com.bijay.expensetracker.resources;

import com.bijay.expensetracker.domain.Category;
import com.bijay.expensetracker.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "")
    public String getAllCategories(HttpServletRequest request) {
        int userId = (Integer) request.getAttribute("userId");
        return "Authenticated! User id: " + userId;
    }

    @PostMapping(value = "")
    public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String, Object> categoryMap){
        int userId = (Integer) request.getAttribute("userId");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");
        Category category = categoryService.addCategory(userId, title, description);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

}
