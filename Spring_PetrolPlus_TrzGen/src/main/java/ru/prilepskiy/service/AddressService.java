package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.Address;
import ru.prilepskiy.domain.P5Config;
import ru.prilepskiy.repository.AddressRepository;
import ru.prilepskiy.repository.P5ConfigRepository;

import java.util.LinkedList;
import java.util.List;

/**
 * Список АЗС моего эмитента.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Service
public class AddressService {

    @Autowired
    P5ConfigRepository p5ConfigRepository;

    @Autowired
    AddressRepository addressRepository;

    /**
     * Ветрет Адреса АЗС моего эмитента.
     * @return
     */
    public Iterable<Address> get() {
        final P5Config p5Config = this.p5ConfigRepository.findFirstByOrderByIdEmitentAsc();
        return this.addressRepository.findByIdEmitentOrderByIdTochkiObslugivaniya(p5Config.getIdEmitent());
    }
}
