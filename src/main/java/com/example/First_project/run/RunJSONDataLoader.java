package com.example.First_project.run;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunJSONDataLoader {
    private final JDBCClientRunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJSONDataLoader(JDBCClientRunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    // @Override
    // public void run(String... args) throws Exception{
    // if(runRepository.count() == 0){
    // try(InputStream inputStream =
    // TypeReference.class.getResourceAsStream("/data/runs.json")){
    // Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
    // runRepository.saveAll(allRuns);
    // } catch(IOException e){
    // throw new RuntimeException(e);
    // }
    // }else{
    // System.out.println("Not loading runs from json because db contains data");
    // }
    // }
}
