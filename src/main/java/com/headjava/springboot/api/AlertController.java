package com.headjava.springboot.api;

import com.headjava.springboot.api.support.AlertResponse_;
import com.headjava.springboot.dao.Alert;
import com.headjava.springboot.api.support.AlertResponse;
import com.headjava.springboot.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @RequestMapping(value = "/alerts", method = RequestMethod.POST)
    public ResponseEntity<AlertResponse> saveAlerts(@RequestBody Alert alert) {
        try {
            alertService.saveAlerts(alert);
            AlertResponse response = new AlertResponse(alert.getAlert_id(), "");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = e.getMessage();
            AlertResponse errorResponse = new AlertResponse(alert.getAlert_id(), errorMsg);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/alerts", method = RequestMethod.GET)
    public ResponseEntity<AlertResponse_> getAlerts(@RequestParam(name = "service_id") String serviceId,
                                                    @RequestParam(name = "start_ts") long startTimeStamp,
                                                    @RequestParam(name = "end_ts") long endTimeStamp) {
        try{
            String service_name = alertService.getServiceNameByServiceId(serviceId);
            List<Alert> alerts = alertService.getAlertsByServiceIdAndTimeStamp(serviceId, startTimeStamp, endTimeStamp);

            AlertResponse_ response = new AlertResponse_(serviceId, service_name, alerts, true, null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            AlertResponse_ errorResponse = new AlertResponse_(serviceId, null, null, false, "Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
