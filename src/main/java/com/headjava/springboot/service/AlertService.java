package com.headjava.springboot.service;

import com.headjava.springboot.dao.Alert;
import com.headjava.springboot.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository){
        this.alertRepository = alertRepository;
    }

    public void saveAlerts(Alert alert){
        alertRepository.save((alert));
    }

    public String getServiceNameByServiceId(String serviceId){

        Optional<Alert> alertOptional = alertRepository.findById(serviceId);
        System.out.println(alertOptional);
        if(alertOptional.isPresent()){
            Alert alert = alertOptional.get();
            return alert.getService_name();
        } else {
            return null;
        }
    }

    public List<Alert> getAlertsByServiceIdAndTimeStamp(String serviceId, long startTS, long endTS){

        List<Alert> alerts = alertRepository.findAll();

        List<Alert> results = new ArrayList<>();

        for(Alert alert: alerts){

            long alertTimeStamp = Long.parseLong(alert.getAlert_ts());
            //
            if(alertTimeStamp >= startTS && alertTimeStamp <= endTS){
                results.add(alert);
            }
        }

        return results;
    }

}
