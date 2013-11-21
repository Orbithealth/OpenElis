/*
* The contents of this file are subject to the Mozilla Public License
* Version 1.1 (the "License"); you may not use this file except in
* compliance with the License. You may obtain a copy of the License at
* http://www.mozilla.org/MPL/ 
* 
* Software distributed under the License is distributed on an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
* License for the specific language governing rights and limitations under
* the License.
* 
* The Original Code is OpenELIS code.
* 
* Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
*/

package org.bahmni.feed.openelis.feed.contract.openmrs.encounter;

import org.bahmni.feed.openelis.feed.contract.openmrs.OpenMRSPatient;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenMRSEncounter {
    private String uuid;
    private OpenMRSPatient patient;
    private List<OpenMRSOrder> orders = new ArrayList<>();

    public OpenMRSEncounter() {
    }

    public OpenMRSEncounter(String uuid, OpenMRSPatient patient, List<OpenMRSOrder> orders) {

        this.uuid = uuid;
        this.patient = patient;
        this.orders = orders;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPatient(OpenMRSPatient patient) {
        this.patient = patient;
    }

    public String getUuid() {
        return uuid;
    }

    public List<OpenMRSOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<OpenMRSOrder> orders) {
        this.orders = orders;
    }

    public OpenMRSPatient getPatient() {
        return patient;
    }

    public boolean hasLabOrder() {
        for (OpenMRSOrder openMRSOrder : orders) {
            if (openMRSOrder.isLabOrder())
                return true;
        }
        return false;
    }

    public List<OpenMRSOrder> getLabOrders() {
        List<OpenMRSOrder> labOrders = new ArrayList<>();
        for (OpenMRSOrder openMRSOrder : orders) {
            if (openMRSOrder.isLabOrder())
                labOrders.add(openMRSOrder);
        }
        return labOrders;
    }
}