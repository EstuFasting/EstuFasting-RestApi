package edu.estu.estufastingrestapi.core.crosscuttingconcerns.aspects;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.PhoneNumber;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.ReflectionHelper;
import edu.estu.estufastingrestapi.core.model.constants.Validation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class PhoneNumberAspect {

    private static String getFormattedPhoneNumber(String phone) {
        if (phone == null) return "";
        if (!phone.matches(Validation.User.RGX_PHONE_NUMBER)) return phone;
        phone = phone.replaceAll("[\\s-()]", "");
        StringBuilder body = new StringBuilder(phone.substring(phone.length() - 10));
        StringBuilder countryCode = new StringBuilder(phone.substring(0, phone.length() - 10));
        body.insert(8, "-");
        body.insert(6, "-");
        body.insert(3, "-");
        body.insert(0, "-");
        if (countryCode.length() > 0 && countryCode.charAt(0) != '+') countryCode.insert(0, "+");
        if (countryCode.length() == 2 && countryCode.charAt(0) == '+' && countryCode.charAt(1) == '0')
            countryCode.deleteCharAt(0);
        if (countryCode.length() == 0) countryCode.insert(0, "0");
        countryCode.append(body);
        return countryCode.toString();
    }

    @Around("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.PhoneNumber (*), ..))")
    public Object editPhoneNumber(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        List<Object> phoneNumbers =
                ReflectionHelper.getArgsByAnnotation(AopHelper.getMethodParameters(pjp.getTarget().getClass(), (MethodSignature) pjp.getSignature()), pjp.getArgs(), PhoneNumber.class);
        for (int i = 0; i < args.length; i++)
            if (phoneNumbers.contains(args[i]))
                args[i] = getFormattedPhoneNumber(args[i].toString());
        return pjp.proceed(args);
    }

}
