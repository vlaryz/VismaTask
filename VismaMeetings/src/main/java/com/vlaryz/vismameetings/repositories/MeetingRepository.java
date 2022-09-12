package com.vlaryz.vismameetings.repositories;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vlaryz.vismameetings.interfaces.IMeetingRepository;
import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MeetingRepository implements IMeetingRepository {

    private String meetingDatabase;

    public MeetingRepository() {
        //this.meetingDatabase = "Meetings.json";
        this.meetingDatabase = "Meetings.json";
    }

    @Override
    public int addMeeting(Meeting meeting) {
        var meetings = getMeetings();
        meetings.add(meeting);

        Gson gson = new Gson();
        String json = gson.toJson(meetings);

        try (FileWriter file = new FileWriter(meetingDatabase)) {
            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return meeting.getId();
    }

    @Override
    public void deleteMeeting(int id) {

    }

    @Override
    public void addPersonToMeeting(int id, Person person) {

    }

    @Override
    public void removePersonFromMeeting(int id, int personId) {

    }

    @Override
    public List<Meeting> getMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(meetingDatabase));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Meeting> readerList = new Gson().fromJson(reader, new TypeToken<List<Meeting>>() {}.getType());
        if(readerList != null)
            meetings.addAll(readerList);

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return meetings;
    }
}
