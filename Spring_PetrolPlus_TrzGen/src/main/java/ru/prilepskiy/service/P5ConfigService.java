package ru.prilepskiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prilepskiy.domain.P5Config;
import ru.prilepskiy.repository.P5ConfigRepository;

/**
 * Номер моего эмитента.
 *
 * Created by VLADIMIR on 24.05.2018.
 */
@Service
public class P5ConfigService {

    @Autowired
    private P5ConfigRepository p5ConfigRepository;

    /**
     * Вернет моего эмитента.
     * @return
     */
    public P5Config getP5Config() {
        return this.p5ConfigRepository.findFirstByOrderByIdEmitentAsc();
    }

}
