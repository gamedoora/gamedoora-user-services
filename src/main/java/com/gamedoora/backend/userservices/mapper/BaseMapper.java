package com.gamedoora.backend.userservices.mapper;

import java.util.Date;

public abstract class BaseMapper {

    private String creator = "GameDoora";

    public String getCreatedBy(){
        return creator;
    }

    public String getUpdatedBy(){
        return creator;
    }

    public Date getNewDate(){
        return new Date();
    }
}
