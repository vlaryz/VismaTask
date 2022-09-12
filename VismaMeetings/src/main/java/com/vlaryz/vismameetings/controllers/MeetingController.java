package com.vlaryz.vismameetings.controllers;

import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;
import com.vlaryz.vismameetings.models.enums.Category;
import com.vlaryz.vismameetings.models.enums.Type;
import com.vlaryz.vismameetings.services.MeetingService;
import jdk.jfr.DataAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("meetings")
public class MeetingController {

    private MeetingService meetingService;

    public MeetingController(MeetingService service) {
        this.meetingService = service;
    }

    @PostMapping("/add")
    public void addMeeting() {
        Person person = new Person(0, "Vladas");
        var result = meetingService.createMeeting(new Meeting(0, person, Category.HUB, Type.LIVE, new Date(), new Date()));
        System.out.println("result: " + result);
    }

    @GetMapping("/list")
    public List<Meeting> listMeetings() {

        var result = meetingService.listMeetings();
        System.out.println("result: listMeetings:");
        return result;
    }

}
