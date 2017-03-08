package com.myproject.poverty.console.config;

import java.io.IOException;
import java.util.*;

import com.myproject.poverty.core.properties.OrderedProperties;
import com.myproject.poverty.core.shiro.RolesOrFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

/**
 * Created by miracle on 2017/3/8.
 */
@Configuration
public class ShiroConfiguration {

    private static final String CRLF= "\r\n";

    private static final String LAST_AUTH_STR= "/** =authc\r\n";

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //  该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }

    @Bean(name = "shiroDbRealm")
    public ShiroDbRealm getShiroRealm() {
        ShiroDbRealm realm = new ShiroDbRealm();
        realm.setCredentialsMatcher(getHashedCredentialsMatcher());
        return realm;
    }

    @Bean(name = "rolesOrFilter")
    public RolesOrFilter getRolesOrFilter() {
        return new RolesOrFilter();
    }

    @Bean(name = "passwordMatcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    @Bean(name = "shiroEhcacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache/ehcache-shiro.xml");
        return em;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getShiroRealm());
        defaultWebSecurityManager.setCacheManager(getEhCacheManager());
        return defaultWebSecurityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }

    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean
                .setSecurityManager(getDefaultWebSecurityManager());
        StringBuffer sb = new StringBuffer();
        sb.append(getFixedAuthRule())
                .append(getDynaAuthPermission())
                .append(LAST_AUTH_STR);
        shiroFilterFactoryBean.setFilterChainDefinitions(sb.toString());
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/loginSuccess");
        Map<String, Filter> filters = new HashMap<>();
        filters.put("rolesOrFilter", getRolesOrFilter());
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }

    //得到动态权限规则

    private String getDynaAuthPermission() {

        StringBuffer sb = new StringBuffer();
        Map<String, Set<String>> rules = new HashMap<String,Set<String>>();

        for(Map.Entry<String, Set<String>> entry :rules.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append("authc,permissionOrFilter").append(entry.getValue()).append(CRLF);
        }
        return sb.toString();

    }

    //得到固定权限验证规则串

    private String getFixedAuthRule() {

        StringBuffer sb = new StringBuffer();

        ClassPathResource cp = new ClassPathResource("fixed_auth_res.properties");
        Properties properties = new OrderedProperties();

        try{
            properties.load(cp.getInputStream());
        } catch(IOException e) {
            throw new RuntimeException("load fixed_auth_res.properties error!");
        }

        for(Iterator<Object> its = properties.keySet().iterator(); its.hasNext();) {
            String key = (String)its.next();
            sb.append(key).append(" = ").append(properties.getProperty(key).trim()).append(CRLF);

        }

        return sb.toString();



    }

}
