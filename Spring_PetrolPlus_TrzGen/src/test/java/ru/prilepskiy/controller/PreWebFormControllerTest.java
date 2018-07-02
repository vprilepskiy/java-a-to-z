package ru.prilepskiy.controller;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import ru.prilepskiy.domain.Address;
import ru.prilepskiy.domain.Client;
import ru.prilepskiy.service.AddressService;
import ru.prilepskiy.service.CardService;
import ru.prilepskiy.service.P5ConfigService;
import ru.prilepskiy.service.TypeOfServiceService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by VLADIMIR on 06.06.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class PreWebFormControllerTest {

    @Mock
    AddressService addressService;

    @Mock
    CardService cardService;

    @Mock
    P5ConfigService p5ConfigService;

    @Mock
    TypeOfServiceService typeOfServiceService;


    @InjectMocks
    private PreWebFormController preWebFormController;


    @Test
    public void getClientByGrNomer() throws Exception {
        final Client client = new Client();
        final long grNomer = 498000011;

        //prepare
        Mockito.when(this.cardService.getClientByGrNomer(grNomer)).thenReturn(client);

        //testing
        Client assertClient = this.preWebFormController.getClientByGrNomer(grNomer);

        //validate
        Assert.assertThat(assertClient, Is.is(client));
    }

    @Test
    public void getClientByGrNomer0() throws Exception {
        final Client client = new Client();
        final long grNomer = 498000011;

        //prepare
        Mockito.when(this.cardService.getClientByGrNomer(grNomer)).thenReturn(client);

        //testing
        Client assertClient = this.preWebFormController.getClientByGrNomer(grNomer);

        //validate
        Mockito.verify(this.cardService).getClientByGrNomer(grNomer);
    }

}