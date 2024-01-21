package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.ResultDto;
import com.aitnacer.LabXpert.entity.Result;

import java.util.List;

public interface IResultService {

    Result createResult(Result result);
    Result updateResult(Result result);

    Result getResult(Long resultId);


}
