package org.digevil.serviceboot3.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/time")
public class TimeController {

    private static final Logger log = LoggerFactory.getLogger(TimeController.class);

    @GetMapping("/current")
    @Operation(summary = "获取时间", description = "获取服务器当前时间")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved"), @ApiResponse(responseCode = "404", description = "Not found - The product was not found")})
    public String current() {
        log.info("current_called");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        return sdf.format(new Date());
    }

}
