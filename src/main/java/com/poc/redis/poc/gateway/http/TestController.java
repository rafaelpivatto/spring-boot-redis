package com.poc.redis.poc.gateway.http;

import com.poc.redis.poc.domain.Test;
import com.poc.redis.poc.usecases.TestCRUD;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Api(tags = "Rest api for test crud operations", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    private TestCRUD testCRUD;

    @Autowired
    public TestController(TestCRUD testCRUD) {
        this.testCRUD = testCRUD;
    }

    @ApiOperation(value = "Add a test item")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Ok", response = Test.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Test> add(@RequestBody final Test testItem){

        testCRUD.save(testItem);

        return new ResponseEntity<>(testItem, HttpStatus.CREATED);
    }

    @ApiOperation(value = "update a test item")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Test.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Test> update(@RequestBody final Test testItem){

        testCRUD.update(testItem);

        return new ResponseEntity<>(testItem, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a test item")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Test.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Test> delete(@ApiParam(required = true) @PathVariable final String itemId){

        testCRUD.delete(itemId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Find a test item by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Test.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(value = "/{itemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Test> getById(@ApiParam(required = true) @PathVariable final String itemId){

        Test item = testCRUD.findById(itemId);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
