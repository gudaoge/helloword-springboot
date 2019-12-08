package com.origin.demo.json;

import com.origin.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-22
 */
@RequestMapping("/event")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/publish")
    public void publish() {
        eventService.publish();
    }
}
