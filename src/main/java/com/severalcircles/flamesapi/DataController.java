/*
 * Copyright (c) 2021 Several Circles.
 */

package com.severalcircles.flamesapi;

import com.severalcircles.flames.data.base.FlamesDataManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SuppressWarnings("ALL")
@RestController
public class DataController {
    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        try {
            return new ResponseEntity(FlamesDataManager.readUser(id).createData(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity("<!DOCTYPE html><html><head><script type=\"text/javascript\">window.location=\"https://flamesapi.severalcircles.com/error/404\"</script></head></html>",HttpStatus.NOT_FOUND);
        }
    }
}
