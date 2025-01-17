package com.example.controller;

import com.example.exceptions.CategoryException;
import com.example.exceptions.ItemException;
import com.example.exceptions.ResturantException;
import com.example.model.Category;
import com.example.model.Item;
import com.example.model.Restaurant;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hoodiefoodie")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping("/item/{restaurantName}")
    private ResponseEntity<Item> addItemHandler(@RequestBody  Item item, @PathVariable("restaurantName") String restaurantName) throws ResturantException {
      Item items=itemService.addItem(item,restaurantName);
      return new ResponseEntity<>(items, HttpStatus.CREATED);

    }
    @PutMapping("item")
    private ResponseEntity<Item> updateItemHandler(@RequestBody  Item item) throws ItemException {
        Item uitem=itemService.updateItem(item);
        return new ResponseEntity<>(uitem,HttpStatus.ACCEPTED);
    }
    @GetMapping("item")
    private ResponseEntity<Item> viewItemHandler(@RequestBody Item item) throws ItemException {
        Item item1=itemService.viewItem(item);
        return new ResponseEntity<>(item1,HttpStatus.FOUND);
    }
    @DeleteMapping("item/{itemId}")
    private ResponseEntity<Item> removeItemHandler(@PathVariable("itemId") String itemId) throws ItemException {
        Item ditem=itemService.removeItem(itemId);
        return new ResponseEntity<>(ditem,HttpStatus.GONE);
    }

    @GetMapping("itemscat/{catid}")
    private ResponseEntity<List<Item>> viewAllItemByCategoryHandler(@PathVariable("catid") String catid) throws ItemException, CategoryException {
        List<Item> items=itemService.viewAllItems(catid);
        return new ResponseEntity<>(items,HttpStatus.FOUND);
    }

    @GetMapping("itemsres/{resId}")
    private ResponseEntity<List<Item>> viewAllItemByRestaurantHandler(@PathVariable("resId") String resId) throws ItemException, ResturantException {
        List<Item> items=itemService.viewAllItem(resId);
        return new ResponseEntity<>(items,HttpStatus.FOUND);
    }
  @GetMapping("items/{ItemName}")
  private ResponseEntity<List<Item>> viewAllItemsByNameHandler(@PathVariable("ItemName") String ItemName) throws ItemException {
        List<Item> items=itemService.viewAllItemsByName(ItemName);
        return new ResponseEntity<>(items,HttpStatus.FOUND);
  }


}
