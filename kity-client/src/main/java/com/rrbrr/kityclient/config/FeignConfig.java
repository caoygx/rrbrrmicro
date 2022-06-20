package com.rrbrr.kityclient.config;

import feign.Logger;

//@Configuration
public class FeignConfig {
    //@Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
