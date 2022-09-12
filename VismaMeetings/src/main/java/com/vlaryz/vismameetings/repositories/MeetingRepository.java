package com.vlaryz.vismameetings.repositories;

import com.vlaryz.vismameetings.interfaces.IMeetingRepository;
import com.vlaryz.vismameetings.models.Meeting;
import com.vlaryz.vismameetings.models.Person;

import java.util.List;

public class MeetingRepository implements IMeetingRepository {

    @Override
    public int addMeeting(Meeting meeting) {
        return 0;
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
        return null;
    }
}
