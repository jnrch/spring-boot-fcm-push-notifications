package net.mestwin.fcmpushnotifications;

import net.mestwin.fcmpushnotifications.controller.PushNotificationController;
import net.mestwin.fcmpushnotifications.firebase.FCMClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value= PushNotificationController.class, secure = false)
public class PushNotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FCMClient fcmService;

    @Test
    public void sendTestMessageViaAPI() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/send"
        ).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
