package com.vlaryz.vismameetings.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vlaryz.vismameetings.models.enums.Category;
import com.vlaryz.vismameetings.models.enums.Type;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
public class Meeting implements Serializable {
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
