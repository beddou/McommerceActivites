package com.clientui.proxies;


import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( contextId = "ExpeditionClient",name = "zuul-server")
@RibbonClient(name = "microservice-expeditions")
public interface MicroserviceExpeditionProxy {

    @GetMapping(value = "/microservice-expeditions/expeditions/{id}")
    ExpeditionBean recupererUneExpedition(@PathVariable ("id") int id);
}
