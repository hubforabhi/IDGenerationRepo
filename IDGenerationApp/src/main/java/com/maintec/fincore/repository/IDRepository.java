package com.maintec.fincore.repository;

import com.maintec.fincore.entity.ID;
import com.maintec.fincore.entity.projection.IDSearchByIdDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDRepository extends JpaRepository<ID, Long> {

    @Query(value =
            "select " +
                "id_table.fc_id as id, fc_personal as personal, company.fc_firm_name firmName, customer.fc_cust_first_name as fname," +
                "fc_num_cross_main as cross_main, fc_area_location as area, fc_block_phase_stage as block, fc_landmark as landmark, " +
                "gm2.fc_description as tatkal, gm1.fc_description as city, fc_pin_code as pincode," +
                "fc_cust_middle_name as mname, fc_cust_last_name as lname, fc_initial as initial " +
            "from id_table " +
                "left outer join customer on customer.FC_CUSTOMER_ID=id_table.fc_customer "+
                "left outer join company on company.fc_company_id=id_table.fc_company " +
                "left outer join adderess on adderess.FC_ID_ADDRESS=id_table.fc_id " +
                "and adderess.fc_communication_address=true "+
                "left outer join general_masters gm1 on gm1.FC_DESCRIPTION=adderess.fc_city " +
                "left outer join general_masters gm2 on gm2.FC_DESCRIPTION=adderess.fc_taluk " +
                //"left outer join general_masters gm1 on gm1.fc_general_masters_id=cast(adderess.fc_city as bigint) " +
                //"left outer join general_masters gm2 on gm2.fc_general_masters_id=cast(adderess.fc_taluk as bigint) " +
            "where id_table.fc_id=:id order by fc_id", nativeQuery = true)
    //TODO: Uncomment above 2 query lines to be oracle compliant
    List<IDSearchByIdDTO> findIDSearchById(@Param("id") Long id);
}
