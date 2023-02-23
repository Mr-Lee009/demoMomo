package vn.com.momo.demo.entities;

import vn.com.momo.demo.entities.enums.DayoffPeriod;
import vn.com.momo.demo.entities.enums.RequestStatuts;

import java.util.Date;

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
