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

@JsonIgnoreProperties({"requestUser","request","key"})
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

    public class DayoffRequestKey {
        public DayoffPeriod offType;
        public RequestStatuts status;
        public Date offDate;

        public DayoffRequestKey(DayoffPeriod offType, RequestStatuts status, Date offDate) {
            this.offType = offType;
            this.status = status;
            this.offDate = offDate;
        }
        public DayoffRequestKey() {

        }
        @Override
        public int hashCode() {
            return this.offDate.hashCode() + this.offDate.hashCode() + this.offType.hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof DayoffRequestKey dayoffRequestKey) {
                return offType == dayoffRequestKey.offType && offDate == dayoffRequestKey.offDate
                        && status == dayoffRequestKey.status;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("red", "blue", "blue", "green", "red","blue","red");
        List<String> otherList = Arrays.asList("red", "green", "green", "yellow","red");

        Set<String> result = list.stream()
                            .distinct()
                            .filter(otherList::contains)
                            .collect(Collectors.toSet());

        System.out.println(result);


    }
}
