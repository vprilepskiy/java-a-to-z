package ru.job4j.manager;

/**
 * Created by VLADIMIR on 13.02.2017.
 */
public interface IMenu {

    /**
     * Вызывает действие в зваисимости от выбранного пункта меню.
     * @param actions - actions.
     */
    void menuNavigator(IActions actions);

}
