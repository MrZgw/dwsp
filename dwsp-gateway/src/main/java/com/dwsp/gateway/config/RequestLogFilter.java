//package com.dwsp.gateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
///**
// * 日志过滤器,webFlux跟mvc不太一样,实现自定义过滤器要实现webFilter接口
// *
// * @author zgw
// */
//@Component
//@Slf4j
//public class RequestLogFilter implements WebFilter {
//
//    /**
//     * 日志打印
//     *
//     * @param serverWebExchange
//     * @param webFilterChain
//     * @return
//     */
//    @Override
//    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
//        ServerHttpRequest request = serverWebExchange.getRequest();
//        log.info("请求url {},请求方法method is [{}]", request.getURI(), request.getMethod());
//        log.info("请求头信息{}", request.getHeaders());
//        //TODO webflux请求体信息获取比较复杂
//        return webFilterChain.filter(serverWebExchange);
//    }
//}
