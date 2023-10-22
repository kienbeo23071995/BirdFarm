package com.example.birdfarmprojectbe.repository.impl;

import com.example.birdfarmprojectbe.dto.MedicineCustomDTO;
import com.example.birdfarmprojectbe.dto.MedicineDTO;
import com.example.birdfarmprojectbe.models.BirdMedicine;
import com.example.birdfarmprojectbe.repository.BirdMedicineCustomRepository;
import com.example.birdfarmprojectbe.ulti.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BirdMedicineRepositoryImpl implements BirdMedicineCustomRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertBulk(List<MedicineCustomDTO> birdMedicines) {
        String sql =
                "INSERT INTO [dbo].[bird_medicine]\n" +
                        "           ([date]\n" +
                        "           ,[quantity]\n" +
                        "           ,[birdid]\n" +
                        "           ,[medicineid])\n" +
                        "     VALUES\n" +
                        "           (?,?,?,?)";
        int[][] ints = jdbcTemplate.batchUpdate(
                sql,
                birdMedicines,
                50,
                (ps, detail) -> {
                    Helper.setParam(ps,1,detail.getDate());
                    Helper.setParam(ps,2,detail.getQuantity());
                    Helper.setParam(ps,3,detail.getBirdID());
                    Helper.setParam(ps,4,detail.getMedicineID());
                }
        );
    }
}
