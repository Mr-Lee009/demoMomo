package vn.com.momo.service;

import org.springframework.stereotype.Service;
import vn.com.momo.ConsecutiveHeap;
import vn.com.momo.demo.entities.DayoffRequest;
import vn.com.momo.demo.entities.DayoffRequestKey;

import java.util.Date;

@Service
public class DayoffService {
    private class DayoffKeyGenerator implements ConsecutiveHeap.IKeyGenerator<DayoffRequestKey,DayoffRequest>{

        @Override
        public DayoffRequestKey GenerateKey(DayoffRequest dayoffRequest) {
            return dayoffRequest.getKey();
        }

        @Override
        public DayoffRequestKey GenerateNextKey(DayoffRequestKey key) {
            return new DayoffRequestKey(key.offType,key.status,new Date(key.offDate.getTime()+(24*60*60)));
        }

        @Override
        public DayoffRequestKey GeneratePreviousKey(DayoffRequestKey dayoffRequestKey) {
            return null;
        }
    }
}
