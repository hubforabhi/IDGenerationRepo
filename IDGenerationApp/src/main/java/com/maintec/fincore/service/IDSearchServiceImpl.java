package com.maintec.fincore.service;

import com.maintec.fincore.entity.Bank;
import com.maintec.fincore.entity.User;
import com.maintec.fincore.entity.projection.IDSearchByIdDTO;
import com.maintec.fincore.model.IDSearchRequestModel;
import com.maintec.fincore.model.IDSearchResponseModel;
import com.maintec.fincore.model.SearchByIDCompanyModel;
import com.maintec.fincore.model.SearchByIDCustomerModel;
import com.maintec.fincore.repository.IDRepository;
import com.maintec.fincore.repository.UserRepository;
import com.maintec.fincore.util.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.maintec.fincore.util.Util.fixLength;

@Service
@Slf4j
public class IDSearchServiceImpl implements IDSearchService {

    @Autowired
    private IDRepository idRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IDSearchResponseModel searchById(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setId(idSearchRequestModel.getId());
        dtoListMapper.accept(idRepository.findIDSearchById(Long.parseLong(idSearchRequestModel.getId())), idSearchResponseModel);
        return idSearchResponseModel;
    }

    @Override
    public IDSearchResponseModel searchByName(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setName(idSearchRequestModel.getName());
        dtoListMapper.accept(idRepository.findIDSearchByName(idSearchRequestModel.getId()), idSearchResponseModel);
        return idSearchResponseModel;
    }

    @Override
    public IDSearchResponseModel searchByAadhaar(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setAadhaar(idSearchRequestModel.getAadhaar());
        dtoListMapper.accept(idRepository.findIDSearchByAadhaar(idSearchRequestModel.getId()), idSearchResponseModel);
        return idSearchResponseModel;
    }

    @Override
    public IDSearchResponseModel searchByPfNo(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setPfNo(idSearchRequestModel.getAadhaar());
        List<IDSearchByIdDTO> dtoList = idRepository.findIDSearchByAadhaar(idSearchRequestModel.getPfNo());
        dtoListMapper.accept(dtoList, idSearchResponseModel);
        return idSearchResponseModel;
    }

    @Override
    public IDSearchResponseModel searchByLicenseNo(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setLicenseNo(idSearchRequestModel.getLicenseNo());
        dtoListMapper.accept(idRepository.findIDSearchByLicenseNo(idSearchRequestModel.getLicenseNo()), idSearchResponseModel);
        return idSearchResponseModel;
    }

    @Override
    public IDSearchResponseModel searchByAccountNo(IDSearchRequestModel idSearchRequestModel) {
        IDSearchResponseModel idSearchResponseModel = new IDSearchResponseModel();
        idSearchResponseModel.setAccountNo(idSearchRequestModel.getAccountNo());
        Optional<User> userOptional = userRepository.findById(Long.parseLong(idSearchRequestModel.getUserId()));
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            Bank bank = user.getBranch().getBankId();
            idSearchRequestModel.setAccountNo(
                    bank.isCentralised() ? idSearchRequestModel.getAccountNo() : getFullAccountNo(bank.getBankMicrCode(), user, idSearchRequestModel.getAccountNo(),false));
            dtoListMapper.accept(idRepository.findIDSearchByAccountNo(idSearchRequestModel.getAccountNo()), idSearchResponseModel);
        } else {
            idSearchResponseModel.setResponseStatus(ResponseStatus.USER_NOT_FOUND);
        }

        return idSearchResponseModel;
    }

    private static String getFullAccountNo(String micrCode, User user, String accountNo, boolean isBankAccount) {
        if(accountNo == null ) {
            return "0";
        }
        String finalAccountNo = null;
        micrCode = fixLength(micrCode.trim(),3);
        String branchCode = fixLength(user.getBranch().getBranchId().trim(),5);
        finalAccountNo = micrCode+"000"+accountNo;

        return finalAccountNo;
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

    private final BiConsumer<List<IDSearchByIdDTO>, IDSearchResponseModel> dtoListMapper = (dtoList, idSearchResponseModel) -> {
        if(dtoList !=null && !dtoList.isEmpty()) {
            idSearchResponseModel.setCustomers(dtoList.stream().filter(IDSearchByIdDTO::isPersonal).map(searchByIdCustomerMapper).collect(Collectors.toList()));
            idSearchResponseModel.setCompanies(dtoList.stream().filter(Predicate.not(IDSearchByIdDTO::isPersonal)).map(searchByIdCompanyMapper).collect(Collectors.toList()));
            idSearchResponseModel.setResponseStatus(ResponseStatus.OK);
        } else {
            idSearchResponseModel.setResponseStatus(ResponseStatus.ID_NOT_FOUND);
        }
    };

}
