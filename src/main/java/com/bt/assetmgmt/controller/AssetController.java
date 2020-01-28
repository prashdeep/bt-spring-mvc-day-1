package com.bt.assetmgmt.controller;

import com.bt.assetmgmt.model.Item;
import com.bt.assetmgmt.service.AssetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetController {

    private AssetService assetService;

    public AssetController(AssetService assetService){
        this.assetService = assetService;
    }

    @PostMapping(value = "/",
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE},
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})

    @ResponseStatus(HttpStatus.CREATED)
    public Item saveItem(@RequestBody Item item){
        System.out.println("Inside the saveitem method of controller");
        System.out.println("Item >> "+item);
        return this.assetService.save(item);
    }

    @GetMapping(value = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public List<Item> fetchAll(){
       /* if(true){
            throw  new NullPointerException("Exceptoin from the controller layer");
        }*/
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

    //@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntTimeException(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thrown from the asset controller error handler");
    }
}