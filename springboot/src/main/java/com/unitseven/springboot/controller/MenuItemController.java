package com.unitseven.springboot.controller;

import com.unitseven.springboot.Entity.MenuItem;
import com.unitseven.springboot.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/create")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.saveMenuItem(menuItem);
    }

    @GetMapping("/{itemId}")
    public Optional<MenuItem> getMenuItemById(@PathVariable int itemId) {
        return menuItemService.getMenuItemById(itemId);
    }

    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @DeleteMapping("/{itemId}")
    public void deleteMenuItem(@PathVariable int itemId) {
        menuItemService.deleteMenuItem(itemId);
    }
}