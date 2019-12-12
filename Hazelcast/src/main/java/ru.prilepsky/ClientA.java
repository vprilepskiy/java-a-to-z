package ru.prilepsky;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;

import java.util.Collection;

public class ClientA {

    public static void main(String[] args) {
        Collection<HazelcastInstance> allHazelcastClients = HazelcastClient.getAllHazelcastClients();
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();

        IList<String> myList = hazelcastInstance.getList("myList");
        myList.forEach(s -> System.out.println("ClientA : " + s));
    }
}
