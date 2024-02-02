package com.aitnacer.LabXpert.controller;

import com.aitnacer.LabXpert.dtos.scheduling.SchedulingRequestDto;
import com.aitnacer.LabXpert.dtos.scheduling.SchedulingResponseDto;
import com.aitnacer.LabXpert.entity.SimpleAnalyse;
import com.aitnacer.LabXpert.service.ISimpleAnalyseService;
import com.aitnacer.LabXpert.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(Constant.BASE_API_URL +"scheduling")
@AllArgsConstructor
@Slf4j
public class SchedulingController {

    private ISimpleAnalyseService simpleAnalyseService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<SchedulingResponseDto>  createScheduling(@RequestBody  SchedulingRequestDto schedulingRequestDto){
        log.info("Received Scheduling Request: {}", schedulingRequestDto);
        SimpleAnalyse simpleAnalyse = simpleAnalyseService.createSimpleAnalyse(schedulingRequestDto);
        log.info("Mapped to SimpleAnalyse: {}", simpleAnalyse);

        SchedulingResponseDto schedulingResponseDto = modelMapper.map(simpleAnalyse, SchedulingResponseDto.class);
        log.info("Created Scheduling Response: {}", schedulingResponseDto);

        return new ResponseEntity<>(schedulingResponseDto, HttpStatus.CREATED);    }
    @GetMapping
    public ResponseEntity<List<SchedulingResponseDto>> getAllSchedulingResponse(){
        List<SimpleAnalyse> simpleAnalyse = simpleAnalyseService.getAllSimpleAnalyses();
        List<SchedulingResponseDto> schedulingResponseDtos = simpleAnalyse.stream().map((element) -> modelMapper.map(element, SchedulingResponseDto.class)).collect(Collectors.toList());
        return  new ResponseEntity<>(schedulingResponseDtos,HttpStatus.OK);
    }
}
