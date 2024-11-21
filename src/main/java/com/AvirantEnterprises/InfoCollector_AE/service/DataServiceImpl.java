package com.AvirantEnterprises.InfoCollector_AE.service;
import com.AvirantEnterprises.InfoCollector_AE.model.Data;
import com.AvirantEnterprises.InfoCollector_AE.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService{
    @Autowired
    private DataRepository dataRepository;

    @Override
    public void saveData(Data data) {
        dataRepository.save(data);
    }

    @Override
    public Iterable<Data> findAllData() {
        return dataRepository.findAll();
    }

    @Override
    public Data getDataById(Long id) {
        return dataRepository.findById(id).orElse(null);
                // orElseThrow(() -> new RuntimeException("Id not found"));
    }

    @Override
    public void deleteData(Long id) {
        dataRepository.deleteById(id);
    }
}
