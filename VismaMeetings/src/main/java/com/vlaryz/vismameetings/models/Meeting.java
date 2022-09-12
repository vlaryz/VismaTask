package com.vlaryz.vismameetings.models;

import com.vlaryz.vismameetings.models.enums.Category;
import com.vlaryz.vismameetings.models.enums.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Meeting {
    private int id;
    private Person responsiblePerson;
    private Category category;
    private Type type;
    private Date startDate;
    private Date endDate;

    public Meeting(int id, Person responsiblePerson, Category category,
                   Type type, Date startDate, Date endDate) {
        this.id = id;
        this.responsiblePerson = responsiblePerson;
        this.category = category;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
