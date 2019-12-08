package com.origin.demo.service.impl;

import com.origin.demo.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Created by dengqingling on 2019-07-21
 */
@Slf4j
@Service
public class EventServiceImpl implements EventService, ApplicationEventPublisherAware, ApplicationListener {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish() {
        applicationEventPublisher.publishEvent(new ApplicationEvent(new Object()) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
    }

    @Override
    public void receive() {
        log.info("do receive");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("receive event {}" , event.toString());
        receive();
    }
}
