package com.maintec.fincore.service;

import com.maintec.fincore.entity.Company;
import com.maintec.fincore.entity.Customer;
import com.maintec.fincore.entity.projection.IDSearchByIdDTO;
import com.maintec.fincore.model.IDSearchRequestModel;
import com.maintec.fincore.model.IDSearchResponseModel;
import com.maintec.fincore.model.SearchByIDCompanyModel;
import com.maintec.fincore.model.SearchByIDCustomerModel;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IDSearchServiceImpl implements IDSearchService {

    @Autowired
    private IDRepository idRepository;

    @Override
    public IDSearchResponseModel searchById(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setId(idSearchRequestModel.getId());
        List<IDSearchByIdDTO> dtoList = idRepository.findIDSearchById(Long.parseLong(idSearchRequestModel.getId()));
        if(dtoList !=null && !dtoList.isEmpty()) {
            idSearchResponseModel.setCustomers(dtoList.stream().filter(IDSearchByIdDTO::isPersonal).map(searchByIdCustomerMapper).collect(Collectors.toList()));
            idSearchResponseModel.setCompanies(dtoList.stream().filter(Predicate.not(IDSearchByIdDTO::isPersonal)).map(searchByIdCompanyMapper).collect(Collectors.toList()));
            idSearchResponseModel.setResponseStatus(ResponseStatus.OK);
        } else {
            idSearchResponseModel.setResponseStatus(ResponseStatus.ID_NOT_FOUND);
        }
        return idSearchResponseModel;
    }

    private final Function<IDSearchByIdDTO, String> searchByIdNameMapper = (dto) -> {
        StringBuffer nameBuffer = new StringBuffer();
        if(dto.isPersonal()) {
            if(dto.getFname() != null && !"".equalsIgnoreCase(dto.getFname().trim())) {
                nameBuffer.append(dto.getFname());
            }
            if(dto.getMname() != null && !"".equalsIgnoreCase(dto.getMname().trim())) {
                nameBuffer.append(" ");
                nameBuffer.append(dto.getMname());
            }
            if(dto.getLname() != null && !"".equalsIgnoreCase(dto.getLname().trim())) {
                nameBuffer.append(" ");
                nameBuffer.append(dto.getLname());
            }
            if(dto.getInitial() != null && !"".equalsIgnoreCase(dto.getInitial().trim())) {
                nameBuffer.append(" ");
                nameBuffer.append(dto.getInitial());
            }
        } else {
            nameBuffer.append(dto.getFirmName());
        }
        return nameBuffer.toString();
    };

    private final Function<IDSearchByIdDTO, String> searchByIdAddressMapper = (dto) -> {
        StringBuffer addressBuffer = new StringBuffer();
        if(dto.getCrossMain() != null && !"".equalsIgnoreCase(dto.getCrossMain().trim())) {
            addressBuffer.append(dto.getCrossMain());
        }
        if(dto.getArea() != null && !"".equalsIgnoreCase(dto.getArea().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getArea());
        }
        if(dto.getBlock() != null && !"".equalsIgnoreCase(dto.getBlock().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getBlock());
        }
        if(dto.getLandmark() != null && !"".equalsIgnoreCase(dto.getLandmark().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getLandmark());
        }
        if(dto.getLandmark() != null && !"".equalsIgnoreCase(dto.getLandmark().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getLandmark());
        }
        if(dto.getTatkal() != null && !"".equalsIgnoreCase(dto.getTatkal().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getTatkal());
        }
        if(dto.getCity() != null && !"".equalsIgnoreCase(dto.getCity().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getCity());
        }
        if(dto.getPincode() != null && !"".equalsIgnoreCase(dto.getPincode().trim())) {
            addressBuffer.append(" ");
            addressBuffer.append(dto.getPincode());
        }
        return addressBuffer.toString();
    };

    private final Function<IDSearchByIdDTO, SearchByIDCompanyModel> searchByIdCompanyMapper = (dto) -> {
        SearchByIDCompanyModel company = new SearchByIDCompanyModel();
        company.setId(dto.getId());
        company.setName(searchByIdNameMapper.apply(dto));
        company.setAddress(searchByIdAddressMapper.apply(dto));
        return company;
    };

    private final Function<IDSearchByIdDTO, SearchByIDCustomerModel> searchByIdCustomerMapper = (dto) -> {
        SearchByIDCustomerModel customer = new SearchByIDCustomerModel();
        customer.setId(dto.getId());
        customer.setName(searchByIdNameMapper.apply(dto));
        customer.setAddress(searchByIdAddressMapper.apply(dto));
        return customer;
    };

}
