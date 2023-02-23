package vn.com.momo.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class UserMonthlyRequestDto {
    public Integer Id;
    public String username;
    public List<RequestDto> requests;

    public UserMonthlyRequestDto(Integer id, String username) {
        Id = id;
        this.username = username;
    }

    public UserMonthlyRequestDto() {
        this.requests = new ArrayList<>();
    }
}
