package com.dent.web;

import com.dent.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wards")
public class WardRestController {
    private final WardService wardService;

    @Autowired
    public WardRestController(WardService wardService) {
        this.wardService = wardService;
    }

}
