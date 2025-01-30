package com.fasttrack.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = NotExistsByNombreValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface NotExistsByNombre {

	String message() default "La materia ya existe. Selecciona otra";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
