package com.testAPI.Controller;

import com.testAPI.Service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class TestAPI {
    @Autowired
    TestEntityService testEntityService;

    @RequestMapping(value = "/temp", method = RequestMethod.POST)
        public ResponseEntity<Object> checkTemp (@RequestParam double temp){
            Long ts = System.currentTimeMillis();
        if (testEntityService.saveTempLog(temp, ts)) {
                return new ResponseEntity<>("OK", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("error", HttpStatus.CONFLICT);
            }
    }

//    @RequestMapping(value = "/id", method = RequestMethod.POST)
//    public ResponseEntity<Object> checkID (@RequestParam String id){
//        Long ts = System.currentTimeMillis();
//        UUID uuid = UUID.fromString(id);
//        if (testEntityService.saveTempLog(0, ts, uuid)) {
//            return new ResponseEntity<>("OK", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("error", HttpStatus.CONFLICT);
//        }
//    }

    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public ResponseEntity<Object> check () {
        return new ResponseEntity<>(testEntityService.get(), HttpStatus.OK);
    }
}
