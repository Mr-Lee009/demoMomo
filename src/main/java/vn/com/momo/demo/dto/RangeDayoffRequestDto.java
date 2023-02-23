package vn.com.momo.demo.dto;

import vn.com.momo.demo.entities.enums.DayoffPeriod;
import vn.com.momo.demo.entities.enums.RequestStatuts;

import java.util.Date;

public class RangeDayoffRequestDto {
    public Date start;
    public Date end;
    public DayoffPeriod offType;
    public RequestStatuts status;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public DayoffPeriod getOffType() {
        return offType;
    }

    public void setOffType(DayoffPeriod offType) {
        this.offType = offType;
    }

    public RequestStatuts getStatus() {
        return status;
    }

    public void setStatus(RequestStatuts status) {
        this.status = status;
    }
}

