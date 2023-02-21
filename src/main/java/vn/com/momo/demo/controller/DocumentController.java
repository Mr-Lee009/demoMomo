package vn.com.momo.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vn.com.momo.demo.entities.DayoffRequest;
import vn.com.momo.demo.entities.Request;
import vn.com.momo.demo.entities.enums.DayoffPeriod;
import vn.com.momo.demo.entities.enums.RequestStatuts;

import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public String load() {
        return "document";
    }

    @RequestMapping(value = "/load_dayoff", method = RequestMethod.GET)
    public Request loadDayoff() {

        DayoffRequest[] dayoffRequests = new DayoffRequest[]{
                new DayoffRequest(0, new Date(2023, 8, 7), DayoffPeriod.M, RequestStatuts.PD),
                new DayoffRequest(1, new Date(2023, 8, 8), DayoffPeriod.F, RequestStatuts.PD),
                new DayoffRequest(2, new Date(2023, 8, 9), DayoffPeriod.A, RequestStatuts.PD),
                new DayoffRequest(3, new Date(2023, 8, 10), DayoffPeriod.F, RequestStatuts.PD),
        };

        Request request = new Request(1, "request Lee", "dayOff Lee", Arrays.stream(dayoffRequests).toList());

        return request;
    }

    @RequestMapping(value = "/check_log", method = RequestMethod.GET)
    public String checkLog() {
        return "check log!";
    }
    @RequestMapping(value = "/check_log_2", method = RequestMethod.GET)
    public String checkLog2() {
        return "check log 2!";
    }

    @RequestMapping(value = "/check_log_3", method = RequestMethod.GET)
    public String checkLog3() {
        return "check log 3!";
    }

}
