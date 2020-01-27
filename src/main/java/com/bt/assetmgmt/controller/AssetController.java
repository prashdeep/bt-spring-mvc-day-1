package com.bt.assetmgmt.controller;

import com.bt.assetmgmt.model.Item;
import com.bt.assetmgmt.service.AssetService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetController {

    private AssetService assetService;

    public AssetController(AssetService assetService){
        this.assetService = assetService;
    }

    @PostMapping(value = "/",  produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
                consumes =  {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Item saveItem(Item item){
        return this.assetService.save(item);
    }

    @GetMapping(value = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public List<Item> fetchAll(){
        return this.assetService.listAll();
    }

    @GetMapping(value = "/{itemId}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Item fetchItemById( @PathVariable ("itemId") long itemId){
        return this.assetService.findById(itemId);
    }

    @PutMapping(value = "/{itemId}",
                produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
                consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Item fetchItemById( @PathVariable ("itemId") long itemId, @RequestBody Item item){
        return this.assetService.update(itemId, item);
    }

    @DeleteMapping(value = "/{itemId}",
                produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public void deleteItemById( @PathVariable ("itemId") long itemId){
        this.assetService.deleteItemById(itemId);
    }
}