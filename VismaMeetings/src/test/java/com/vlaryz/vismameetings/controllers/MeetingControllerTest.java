package com.vlaryz.vismameetings.controllers;

import com.vlaryz.vismameetings.interfaces.IMeetingRepository;
import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;
import com.vlaryz.vismameetings.models.enums.Category;
import com.vlaryz.vismameetings.models.enums.Type;
import com.vlaryz.vismameetings.repositories.MeetingRepository;
import com.vlaryz.vismameetings.services.MeetingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeetingControllerTest {

    private MeetingService service;
    private IMeetingRepository repository;
    private Meeting meeting;
    private Person person;
    private List<Person> personList = new ArrayList<>();
    private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    public void Setup() {
        repository = new MeetingRepository();
        service = new MeetingService(repository);
        person = new Person(228, "TestPerson");
        //personList.add(person);
        try {
            meeting = new Meeting(person, Category.TEAM_BUILDING,
                    Type.IN_PERSON, ft.parse("2022-09-15"),
                    ft.parse("2022-09-15"));
            meeting.addPerson(person);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void index() throws Exception {


//        RequestBuilder request = MockMvcRequestBuilders.get("/list");
//        MvcResult result = mvc.perform(request).andReturn();
//        System.out.println(result.getResponse().getContentAsString());
        String s = "aboba";
        assertEquals(s, "aboba");
    }

    @Test
    void addMeetingWhenThereIsAlreadyOne() {
        Setup();
        Person newPerson = new Person(12, "TestPerson2");
        try {
            meeting = new Meeting(person, Category.SHORT,
                    Type.LIVE, ft.parse("2022-09-25"),
                    ft.parse("2022-09-26"));
            meeting.addPerson(person);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var result = service.createMeeting(meeting);
        assertEquals(1, result);
    }

    @Test
    void listMeetings() {
    }

    @Test
    void deleteMeeting() {
    }

    @Test
    void addPersonToMeeting() {
    }

    @Test
    void removePersonFromMeeting() {
    }
}