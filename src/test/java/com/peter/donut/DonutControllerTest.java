package com.peter.donut;

import com.peter.donut.model.DonutOrder;
import com.peter.donut.service.DonutService;
import com.peter.donut.util.DonutHelper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(DonutController.class)
class DonutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DonutService donutService;

    private DonutHelper donutHelper = new DonutHelper();

    @Test
    public void whenSubmitIsClicked_orderShouldBePlaced() throws Exception {
        String uri = "/order";

        // given
        List<DonutOrder> donutOrderList = donutHelper.buildOrderList();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.TEXT_PLAIN).content(String.valueOf(donutOrderList))).andReturn();

        // when
        when(donutService.onlineDonutList(donutOrderList)).thenReturn(donutOrderList);

        int status = mvcResult.getResponse().getStatus();

        // then
        assertEquals(200, status);
    }

    @Test
    void displayHistory() {
    }
}