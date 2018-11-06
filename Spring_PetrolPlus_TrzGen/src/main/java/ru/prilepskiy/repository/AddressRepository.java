package ru.prilepskiy.repository;

import org.springframework.data.repository.CrudRepository;
import ru.prilepskiy.domain.Address;
import ru.prilepskiy.domain.AddressPK;

/**
 * Created by VLADIMIR on 24.05.2018.
 */
public interface AddressRepository extends CrudRepository<Address, AddressPK> {

    /**
     * Список адресов по номеру эмитента.
     * @param idEmitent
     * @return
     */
    Iterable<Address> findByIdEmitentOrderByIdTochkiObslugivaniya(Long idEmitent);

}
