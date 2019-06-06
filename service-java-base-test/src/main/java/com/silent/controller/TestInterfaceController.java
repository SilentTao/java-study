package com.silent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* User: silent
 * \* Date: 20/05/19 Time: 17:50
 * \* Description:
 * \
 */
@RestController
public class TestInterfaceController {


    @ResponseBody
    @RequestMapping(value = "/keep", method = RequestMethod.GET)
    public String getKeepalived() {

        return "success";

    }
}
