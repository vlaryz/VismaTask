package com.vlaryz.vismameetings.services;

import com.vlaryz.vismameetings.interfaces.IMeetingRepository;
import com.vlaryz.vismameetings.interfaces.IMeetingService;
import com.vlaryz.vismameetings.models.Meeting;

import java.util.List;

public class MeetingService implements IMeetingService {

    private IMeetingRepository meetingRepository;

    public MeetingService(IMeetingRepository repository) {
        meetingRepository = repository;
    }

    @Override
    public int createMeeting(Meeting meeting) {
        return 0;
    }

    @Override
    public boolean deleteMeeting(int id, int personId) {
        return false;
    }

    @Override
    public boolean addPersonToMeeting(int id, int personId, String name) {
        return false;
    }

    @Override
    public boolean removePersonFromMeeting(int id, int personId) {
        return false;
    }

    @Override
    public List<Meeting> listMeetings() {
        return null;
    }

    @Override
    public List<Meeting> listMeetings(String property, String value) {
        return null;
    }
}
