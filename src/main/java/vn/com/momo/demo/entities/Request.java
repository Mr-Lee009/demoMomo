package vn.com.momo.demo.entities;

import vn.com.momo.demo.entities.abstractions.BaseEntity;
import java.util.List;

public class Request extends BaseEntity<Integer> {
    public Integer Id ;
    public String title;
    public String description;
    public List<DayoffRequest> dayoffRequests;

    public Request(){

    }
    public Request(Integer id, String title, String description, List<DayoffRequest> dayoffRequests) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.dayoffRequests = dayoffRequests;
    }
}
