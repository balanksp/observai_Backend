package com.zaga.repo;

import java.util.List;

import com.zaga.entity.auth.Rule;
import com.zaga.entity.auth.ServiceList;
import com.zaga.entity.auth.ServiceListNew;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceListRepo implements PanacheMongoRepository<ServiceListNew> {


    public ServiceListNew findByServiceName(String serviceName) {
        return find("serviceName = ?1 ", serviceName).firstResult();
    }
    
    public ServiceListNew findByServiceNameAndRuleTypeMatch(String serviceName, String ruleType, List<Rule> rules) {
        List<ServiceListNew> results = find("serviceName = ?1", serviceName).list();
        
        for (ServiceListNew result : results) {
            if (result.getRules().stream().anyMatch(rule -> rule.getRuleType().equals(ruleType))) {
                return result;
            }
        }
    
        return null;
    }
    
    


    public ServiceListNew findMetricByServiceName(String serviceName) {
        return find("serviceName = ?1 and rules.ruleType = ?2", serviceName, "metric").firstResult();
    }

    public ServiceListNew findByServiceNameAndRuleType(String serviceName, String ruleType) {
        return find("serviceName = ?1 and rules.ruleType = ?2", serviceName, ruleType).firstResult();
    }
}
