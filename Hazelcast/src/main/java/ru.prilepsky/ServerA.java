package ru.prilepsky;

import com.hazelcast.core.Client;
import com.hazelcast.core.ClientListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;

import java.util.Set;

public class ServerA {

    public static void main(String[] args) {

//        Set<HazelcastInstance> allHazelcastInstances = Hazelcast.getAllHazelcastInstances();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        instance.getClientService().addClientListener(new ClientListener() {
            @Override
            public void clientConnected(Client client) {
                System.out.println("Client connect : " + client.getName() + ", UUID : " + client.getUuid());
            }

            @Override
            public void clientDisconnected(Client client) {
                System.out.println("Disconnect client : " + client.getName() + ", UUID : " + client.getUuid());
            }
        });

        IList<Object> myList = instance.getList("myList");
        myList.add("Hello A!!!");

        myList.forEach(s -> System.out.println("ServerA : " + s));
    }
}
