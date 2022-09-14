package com.vlaryz.vismameetings.controllers;

import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;
import com.vlaryz.vismameetings.models.enums.Category;
import com.vlaryz.vismameetings.models.enums.Type;
import com.vlaryz.vismameetings.services.MeetingService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("meetings")
public class MeetingController {

    private MeetingService meetingService;

    public MeetingController(MeetingService service) {
        this.meetingService = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("aboba", "variable");
        model.addAttribute("meetings", meetingService.listMeetings());
        System.out.println("size: " + meetingService.listMeetings().size());
        return "index";
    }

    @PostMapping("/add")
    public void addMeeting() {
        Person person = new Person(0,"Vladas");
        var result = meetingService.createMeeting(new Meeting(person, Category.HUB, Type.LIVE, new Date(), new Date()));
        System.out.println("result: " + result);
    }

    @GetMapping("/list")
    public List<Meeting> listMeetings() {

        var result = meetingService.listMeetings();
        System.out.println("result: listMeetings:");
        return result;
    }

    @PostMapping("/delete")
    public boolean deleteMeeting(@RequestParam("id") int id, @RequestParam("personId") int personId) {

        var result = meetingService.deleteMeeting(id, personId);
        System.out.println("result: deleteMeetings:");
        return result;
    }

    @PostMapping("/addPerson")
    public boolean addPersonToMeeting(@RequestParam("id") int id, @RequestParam("personId") int personId, @RequestParam("name") String name) {

        var result = meetingService.addPersonToMeeting(id, personId, name);
        System.out.println("result: addPersonToMeeting:");
        return result;
    }

    @PostMapping("/removePerson")
    public boolean removePersonFromMeeting(@RequestParam("id") int id, @RequestParam("personId") int personId) {

        var result = meetingService.removePersonFromMeeting(id, personId);
        System.out.println("result: removePersonToMeeting:");
        return result;
    }

}
