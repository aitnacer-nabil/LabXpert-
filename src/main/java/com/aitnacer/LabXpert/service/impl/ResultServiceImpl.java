package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.repository.ResultRepository;
import com.aitnacer.LabXpert.service.IResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements IResultService {
    private final ResultRepository resultRepository;


    @Override
    public Result save(double result) {

        Result result1 = Result.builder().result(result).build();
        Result resultSaved = resultRepository.save(result1);
        return  resultSaved;
    }

    @Override
    public Result update(long id, Result result) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
