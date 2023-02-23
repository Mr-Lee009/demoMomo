package vn.com.momo.demo.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import vn.com.momo.demo.entities.abstractions.BaseEntity;
import vn.com.momo.demo.entities.enums.DayoffPeriod;
import vn.com.momo.demo.entities.enums.RequestStatuts;
import vn.com.momo.util.CustomDateDeserializer;
import vn.com.momo.util.CustomDateSerializer;

import java.util.*;
import java.util.stream.Collectors;

@JsonIgnoreProperties({"requestUser", "request", "key"})
public class DayoffRequest extends BaseEntity<Integer> {
    public Integer Id;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date dateTime;


    @JsonProperty("off_type")
    public DayoffPeriod offType = DayoffPeriod.F;

    @JsonProperty("status")
    public RequestStatuts status = RequestStatuts.PD;

    public Integer userId;

    public User requestUser;

    @JsonGetter("request_id")
    public Integer getRequestId() {
        return requestId;
    }

    @JsonProperty("request__Id__X2")
    public Integer requestId = 1997;
    public Request request;

    private DayoffRequestKey _key;
    public DayoffRequestKey key;

    public DayoffRequest(Integer id, Date dateTime, DayoffPeriod offType, RequestStatuts status) {
        this.Id = id;
        this.dateTime = dateTime;
        this.offType = offType;
        this.status = status;
    }

    public DayoffRequestKey getKey() {
        return _key;
    }

    public static void main(String[] args) {
        String[] A = {"6", "5", "4", "5"};
        String[] B = {"6", "1", "4", "5"};
        String[] C = {"16", "13", "14", "15"};

        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList(A));
        map.put("B", Arrays.asList(B));
        map.put("C", Arrays.asList(C));

        List<String> value =  map.values().stream()
                .flatMap(l->l.stream())
                .collect(Collectors.toSet())
                .stream().toList();

        System.out.println(value);

        List<String> list = Arrays.asList("red", "blue", "blue", "green", "red", "blue", "red");
//        List<String> otherList = Arrays.asList("red", "green", "green", "yellow", "red");
//
//        Set<String> result = list.stream()
//                .distinct()
//                .filter(otherList::contains)
//                .collect(Collectors.toSet());
//
//        System.out.println(result);
        System.out.println(String.join("-",list));

    }
}
