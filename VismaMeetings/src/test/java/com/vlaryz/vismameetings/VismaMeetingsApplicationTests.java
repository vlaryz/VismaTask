package com.vlaryz.vismameetings;

import com.vlaryz.vismameetings.controllers.MeetingController;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MeetingController.class)
@ContextConfiguration(classes= SpringApplication.class)
@AutoConfigureMockMvc
class VismaMeetingsApplicationTests {

    private MeetingService service;
    private IMeetingRepository repository;
    private Meeting meeting;
    private Person person;
    private List<Person> personList = new ArrayList<>();

    @Autowired
    private MockMvc mvc;

//    public VismaMeetingsApplicationTests(MockMvc mvc) {
//        this.mvc = mvc;
//    }

    public void Setup() {
        repository = new MeetingRepository();
        service = new MeetingService(repository);
        person = new Person(228, "TestPerson");
        //personList.add(person);

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
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
    public void addMeeting_whenDbNotEmpty_returnMeetingId()
    {
        Setup();

    }
    @Test
    void contextLoads() {
    }

}
