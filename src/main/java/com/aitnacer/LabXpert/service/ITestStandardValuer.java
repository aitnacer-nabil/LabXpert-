package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.TestStandardValueDto;

import java.util.List;

public interface ITestStandardValuer {
    TestStandardValueDto findById(Long id);

    List<TestStandardValueDto> findAll();

    TestStandardValueDto save(TestStandardValueDto testStandardValue);

    TestStandardValueDto update(long id ,TestStandardValueDto testStandardValue);

    void deleteById(Long id);
}
