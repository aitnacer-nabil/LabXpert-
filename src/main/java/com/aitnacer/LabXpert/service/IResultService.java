package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.TestStandardValueDto;
import com.aitnacer.LabXpert.entity.Result;

import java.util.List;

public interface IResultService {



    Result save(double result);

    Result update(long id ,Result result);

    void deleteById(Long id);
}
