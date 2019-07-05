package com.eugene.anotation;


import org.springframework.context.annotation.Import;
import com.eugene.property.OrderFlowOperationProperty;

import java.lang.annotation.*;

@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = OrderFlowOperationProperty.class)
public @interface EnableOrderFlowOperation {
}
