package ru.prilepskiy.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


import java.net.InetAddress;
import java.net.*;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "ru.prilepskiy.repository")
//@ComponentScan(basePackages = {"ru.prilepskiy.service"})
public class Config {

//    @Value("${elasticsearch.host}")
//    private String esHost;
//
//    @Value("${elasticsearch.port}")
//    private int esPort;
//
//    @Value("${elasticsearch.clustername}")
//    private String esClusterName;

//    @Bean
//    public Client client() throws Exception {
//        Settings settings = Settings.builder().put("cluster.name", esClusterName).build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        client.addTransportAddress(new TransportAddress(InetAddress.getByName(esHost), esPort));
//        return client;
//    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }

//    @Bean
//    public Client client(){
//        TransportClient client = null;
//        try{
//            System.out.println("host:"+ host+"port:"+port);
//            client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        return client;
//    }
}

//    @Bean
////    RestHighLevelClient client() {
//////        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
////        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
////        TransportClient client = new RestHighLevelClient(builder);
////        return client;
////    }



//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }

//    @Bean
//    ElasticsearchRestTemplate elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(elasticsearchClient());
//    }



//    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/5.6.0}")
//    private String elasticsearchHome;
//
//    @Value("${elasticsearch.cluster.name:elasticsearch}")
//    private String clusterName;

//    @Bean
//    public Client client() {
//        Settings elasticsearchSettings = Settings.builder()
//            .put("client.transport.sniff", true)
//            .put("path.home", elasticsearchHome)
//            .put("cluster.name", clusterName).build();
//        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
//        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//        return client;
//    }
