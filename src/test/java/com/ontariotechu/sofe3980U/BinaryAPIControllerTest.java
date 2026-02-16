package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

  

    // 3 more tests

     @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2",""))
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    @Test
    public void add4() throws Exception {
        this.mvc.perform(get("/add").param("operand1","").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1010"));
    }

    @Test
    public void add5() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "111").param("operand2", ""))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
		.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
		.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
		.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void and() throws Exception {
        this.mvc.perform(get("/and").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("10"));
    }

    @Test 
    public void andJson() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111));
    }

    @Test 
    public void or() throws Exception {
        this.mvc.perform(get("/or").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }

    @Test 
    public void orJson() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111));
    }

    @Test 
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1000110"));
    }

    @Test 
    public void multiplyJson() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","111").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111));
    } 


}