package com.maintec.fincore.service;

import com.maintec.fincore.entity.GeneralMasters;
import com.maintec.fincore.repository.GeneralMastersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GeneralMastersServiceImpl implements  GeneralMastersService {

    @Autowired
    private GeneralMastersRepository generalMastersRepository;

    @Override
    public Map<String, List<String>> findAll() {
        List<GeneralMasters> generalMastersList = generalMastersRepository.findAll();
        Map<String, List<String>> generalMasters = generalMastersList.stream().collect(
                Collectors.groupingBy(GeneralMasters::getMasterType, Collectors.mapping(GeneralMasters::getDescription, Collectors.toList())));
        return generalMasters;
    }
}
