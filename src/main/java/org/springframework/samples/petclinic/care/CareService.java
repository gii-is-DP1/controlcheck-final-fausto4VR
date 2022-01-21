package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareService {
    
    @Autowired
    CareProvisionRepository careProvisionRepository;

    public List<Care> getAllCares(){
        List<Care> c = careProvisionRepository.findAllCares();
        return c;
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        List<Care> c = careProvisionRepository.findCompatibleCares(petTypeName);
        return c;
    }

    public Care getCare(String careName) {
        return null;
    }

    
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        return null;   
    }

    public List<CareProvision> getAllCaresProvided(){
        return null;
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }
    
}
