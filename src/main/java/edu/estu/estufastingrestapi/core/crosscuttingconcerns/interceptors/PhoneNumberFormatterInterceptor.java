package edu.estu.estufastingrestapi.core.crosscuttingconcerns.interceptors;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.PhoneNumber;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.helper.AopHelper;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(0)
public class PhoneNumberFormatterInterceptor {

    @Pointcut("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.PhoneNumber (*), ..))")
    private void hasAtLeastOneParameterAnnotatedWithPhoneNumber() {/*POINTCUT*/}

    @Around("hasAtLeastOneParameterAnnotatedWithPhoneNumber()")
    public Object editPhoneNumber(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        List<Object> phoneNumbers = AopHelper.getAnnotatedArgs(pjp, PhoneNumber.class);
        for (int i = 0; i < args.length; i++)
            for (Object phoneNumber : phoneNumbers)
                if (phoneNumber == args[i])
                    args[i] = getFormattedPhoneNumber(args[i].toString());
        return pjp.proceed(args);
    }

    // todo performance test
    private static String getFormattedPhoneNumber(String phone) {
        if (phone == null) return null;
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

}
