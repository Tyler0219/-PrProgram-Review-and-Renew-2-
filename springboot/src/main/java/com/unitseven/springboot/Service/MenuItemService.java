package com.unitseven.springboot.Service;

import com.unitseven.springboot.Entity.MenuItem;
import com.unitseven.springboot.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public Optional<MenuItem> getMenuItemById(int itemId) {
        return menuItemRepository.findById(itemId);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public void deleteMenuItem(int itemId) {
        menuItemRepository.deleteById(itemId);
    }
}