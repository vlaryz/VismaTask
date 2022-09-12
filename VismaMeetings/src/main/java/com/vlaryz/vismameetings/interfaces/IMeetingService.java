package com.vlaryz.vismameetings.interfaces;

import com.vlaryz.vismameetings.models.Meeting;

import java.util.List;

public interface IMeetingService {
    public int createMeeting(Meeting meeting);

    public boolean deleteMeeting(int id, int personId);

    public boolean addPersonToMeeting(int id, int personId, String name);

    public boolean removePersonFromMeeting(int id, int personId);

    public List<Meeting> listMeetings();

    public List<Meeting> listMeetings(String property, String value);
}
