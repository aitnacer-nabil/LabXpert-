package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.entity.Result;

public interface IResultService {

    Result createResult(Result result);
    Result updateResult(Result result);

    Result getResult(Long resultId);


}
