package noums.study.pizzahouse.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.enums.Menu;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void order() throws Exception {
        //Given
        OrderRequest request = new OrderRequest();
        request.setMenu(Menu.FRIED_CHICKEN);
        request.setCount(1);
        request.setPayMethod("cash");
        String content = objectMapper.writeValueAsString(request);

        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
        )

                //Then
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void failToOrder() throws Exception {
        //Given
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("menu", "Unknown");
        jsonObject.put("count","1");
        jsonObject.put("payMethod","card");

        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toString())
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
        )

                //Then
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }
}