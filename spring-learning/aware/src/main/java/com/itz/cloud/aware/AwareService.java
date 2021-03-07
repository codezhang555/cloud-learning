package com.itz.cloud.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud.aware
 * @Version 1.0
 * @date 2021/3/7 22:48
 */
@Service
@PropertySource(value = "zhang.properties")
public class AwareService implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, EnvironmentAware {

    private String beanName;

    private ResourceLoader resourceLoader;

    private Environment environment;

    public void output() {
        System.out.println("beanName = " + beanName);
        Resource resource = resourceLoader.getResource("zhang.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String s = br.readLine();
            System.out.println("s = " + s);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String address = environment.getProperty("zhang.address");
        System.out.println("address = " + address);
    }

    /**
     * 获取bean的生成工厂
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    /**
     * 获取bean的名字
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
