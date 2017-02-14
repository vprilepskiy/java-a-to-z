package ru.job4j.manager.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;


/**
 * Created by VLADIMIR on 13.02.2017.
 */
public interface IMenu {

    /**
     * Вызывает действие в зваисимости от выбранного пункта меню.
     * @param actions
     */
    public void menuNavigator(IActions actions);

}
