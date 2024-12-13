package ie.spring.adfProject.aspects;

import ie.spring.adfProject.entities.Household;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Aspect
@Component
public class RepositoryLayerAOP {
    @Before("execution(* ie.spring.adfProject.repositories.HouseholdRepository.findByEircode(..))")
    public void beforeFindHouseholdByEircode(JoinPoint joinPoint) {
        log.info("Before {} executing {} with arguments {}",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @After("execution(* ie.spring.adfProject.repositories.HouseholdRepository.findByEircode(..))")
    public void afterFindHouseholdByEircode(JoinPoint joinPoint) {
        log.info("After {} executed {} with arguments {}",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @AfterReturning(value = "execution(* findByEircode(..))", returning = "households")
    public void afterReturningFromFinByEircode(JoinPoint joinPoint, List<Household> households) {
        log.info("Leaving {} with {}", joinPoint.getSignature().getName(), households);
    }
}
