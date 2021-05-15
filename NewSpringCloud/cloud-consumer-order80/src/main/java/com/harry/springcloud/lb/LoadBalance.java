package com.harry.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {
    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
