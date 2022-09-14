package com.vlaryz.vismameetings.interfaces;

import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;

import java.util.List;

public interface IMeetingRepository {

    public int addMeeting(Meeting meeting);

    public void writeMeetings(List<Meeting> meetings);

    public void deleteMeeting(int id);

    public void addPersonToMeeting(int id, Person person);

    public void removePersonFromMeeting(int id, int personId);

    public List<Meeting> getMeetings();
}
