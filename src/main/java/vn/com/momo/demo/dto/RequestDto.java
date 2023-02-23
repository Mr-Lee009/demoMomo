package vn.com.momo.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class RequestDto {
    public Integer Id;
    public String title;
    public String decription;
    public List<RangeDayoffRequestDto> dayOff;

    public RequestDto() {
        this.dayOff = new ArrayList<>();
    }

    public RequestDto(Integer id, String title, String decription) {
        Id = id;
        this.title = title;
        this.decription = decription;
    }
}
