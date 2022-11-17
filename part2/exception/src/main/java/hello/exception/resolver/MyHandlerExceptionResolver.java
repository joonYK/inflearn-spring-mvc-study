package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 컨트롤러에서 예외가 던져지면 예외를 해결하고 동작을 새로 정의
 *
 * 빈 ModelAndView를 반환 : 뷰를 렌더링 하지 않고, 정상 흐름으로 서블릿이 리턴.
 * ModelAndView 지정 : 뷰를 렌더링.
 * null : 다음 ExceptionResolver를 찾아서 실행. 처리할 수 있는 ExceptionResolver가 없으면 예외 처리 안되고, 기존처럼 예외를 서블릿 밖으로 던짐.
 */
@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, //핸들러(컨트롤러) 정보
                                         Exception ex // 핸들러(컨트롤러)에서 발생한 예외
    ) {
        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");

                //원래는 해당 ex가 WAS까지 던져져서 500 상태 코드로 떨어질 예정이었으나 400으로 변경.
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return new ModelAndView();
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
        }

        return null;
    }
}
