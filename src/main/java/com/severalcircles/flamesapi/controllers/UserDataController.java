/*
 * Copyright (c) 2021 Several Circles.
 */

package com.severalcircles.flamesapi.controllers;

import com.severalcircles.flamesapi.FlamesDataConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SuppressWarnings("ALL")
@RestController
public class UserDataController {
    @GetMapping("/user/{id}/{thing}")
    public ResponseEntity getUser(@PathVariable String id, @PathVariable String thing) {
        int th;
        switch (thing) {
            default:
            case "":
            case "user":
                th = 0;
                break;
            case "stats":
                th = 1;
                break;
            case "funfacts":
                th = 2;
                break;
        }
        try {
            return new ResponseEntity(FlamesDataConnection.getUser(id)[th], HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity("<!DOCTYPE html><html><head><script type=\"text/javascript\">window.location=\"https://flamesapi.severalcircles.com/error/404\"</script></head></html>",HttpStatus.NOT_FOUND);
        }
    }
}
