package io.project.crudprojecthotelcsv.crudprojecthotelkafka.resource;

import io.project.crudprojecthotelcsv.crudprojecthotelkafka.readcsv.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    private CsvReader csvReader;

    @Autowired
    public UserResource(CsvReader csvReader){
        this.csvReader = csvReader;
    }

    @GetMapping("/publish")
    public String post(){
        csvReader.producedata();
        return "Published Successfully";
    }


}
