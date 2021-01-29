package com.peter.donut;

import com.peter.donut.model.DonutOrder;
import com.peter.donut.service.DonutService;
import com.peter.donut.util.DonutHelper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(DonutService.class)
class DonutServiceTest {

    @MockBean
    private DonutService donutService;

    private DonutHelper donutHelper = new DonutHelper();

    @Test
    public void whenOrderIsSubmitted_shouldReturnOrderDetails() {
        // given
        List<DonutOrder> donutOrderList = donutHelper.buildOrderList();

        // when
        when(donutService.onlineDonutList(donutOrderList)).thenReturn(donutOrderList);

        // then
        assertThat(donutOrderList).isNotNull();
    }
}