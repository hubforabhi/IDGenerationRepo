package com.maintec.fincore.service;

import com.maintec.fincore.model.IDSearchRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IDSearchServiceImpl implements IDSearchService {

    public void search(IDSearchRequestModel idSearchRequestModel) {
        switch(idSearchRequestModel.getSearchType()) {
            case "name":
                break;
            case "id":
                break;
            default:

        }
    }
}
