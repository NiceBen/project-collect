package com.niceben.projectspring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.niceben.projectspring.aop")
@EnableAspectJAutoProxy
public class AspectConfig {
}
