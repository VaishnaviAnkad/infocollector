package com.AvirantEnterprises.InfoCollector_AE.service;

import com.AvirantEnterprises.InfoCollector_AE.model.Data;

public interface DataService {
    void saveData(Data data);
    Iterable<Data> findAllData();
    Data getDataById(Long id);
    void deleteData(Long id);
}
