package vn.com.momo.demo.service;

import org.springframework.stereotype.Service;
import vn.com.momo.demo.ConsecutiveHeap;
import vn.com.momo.demo.entities.DayoffRequest;
import vn.com.momo.demo.entities.DayoffRequestKey;
import vn.com.momo.demo.entities.enums.DayoffPeriod;
import vn.com.momo.demo.entities.enums.MonthOfYear;
import vn.com.momo.demo.entities.enums.RequestStatuts;
import vn.com.momo.demo.dto.UserMonthlyRequestDto;

import java.util.Date;

@Service
public class DayoffService {

    public UserMonthlyRequestDto getUserMonthlyRequests(int userId, MonthOfYear monthOfYear) {

        DayoffRequest[] dayoffRequests = new DayoffRequest[]{
                new DayoffRequest(1, new Date(2023, 1, 1), DayoffPeriod.F, RequestStatuts.PD),
                new DayoffRequest(2, new Date(2023, 1, 2), DayoffPeriod.F, RequestStatuts.PD),
                new DayoffRequest(3, new Date(2023, 1, 3), DayoffPeriod.M, RequestStatuts.PD),
                new DayoffRequest(4, new Date(2023, 1, 4), DayoffPeriod.A, RequestStatuts.PD),
                new DayoffRequest(5, new Date(2023, 1, 5), DayoffPeriod.A, RequestStatuts.PD)
        };

        return null;
    }

    private class DayoffKeyGenerator implements ConsecutiveHeap.IKeyGenerator<DayoffRequestKey, DayoffRequest> {
        @Override
        public DayoffRequestKey GenerateKey(DayoffRequest dayoffRequest) {
            return dayoffRequest.getKey();
        }

        @Override
        public DayoffRequestKey GenerateNextKey(DayoffRequestKey key) {
            return new DayoffRequestKey(key.offType, key.status, new Date(key.offDate.getTime() + (24 * 60 * 60)));
        }

        @Override
        public DayoffRequestKey GeneratePreviousKey(DayoffRequestKey dayoffRequestKey) {
            return null;
        }
    }
}
