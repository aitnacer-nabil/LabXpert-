package com.aitnacer.LabXpert.service;

import com.aitnacer.LabXpert.dtos.ReactifDto;

import java.util.List;

public interface IReactifService {
    public ReactifDto createRecatif(ReactifDto reactifdto);
    public ReactifDto updatedRectif(long id, ReactifDto reactifdto);
    public void deleteRectif(long id);

    public List<ReactifDto> getAllReactif();
    public ReactifDto getReactifById(Long id);
}
