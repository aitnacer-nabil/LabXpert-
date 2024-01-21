package com.aitnacer.LabXpert.service.impl;

import com.aitnacer.LabXpert.entity.Result;
import com.aitnacer.LabXpert.exception.common.ApiException;
import com.aitnacer.LabXpert.repository.ResultRepository;
import com.aitnacer.LabXpert.service.IResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements IResultService {

    private ResultRepository resultRepository;
    @Override
    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Result updateResult(Result result) {

        return resultRepository.save(result);
    }

    @Override
    public Result getResult(Long resultId) {
        return resultRepository.findById(resultId).orElseThrow(()->new ApiException("No result found with this id",resultId));
    }


}
