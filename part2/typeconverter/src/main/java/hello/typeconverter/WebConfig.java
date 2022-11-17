package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 스프링 내부에서 사용하는 ConversionService 에 컨버터를 추가
     * Integer <-> String 같은 기본적인 컨버터들은 스프링에서 다 제공해주지만, 직접 등록한 컨버터가 우선적으로 사용됨.
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //컨버터가 포맷터보다 우선순위가 높기때문에 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //포맷터 추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
