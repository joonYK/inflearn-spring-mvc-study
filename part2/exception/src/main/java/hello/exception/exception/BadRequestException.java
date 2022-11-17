package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "잘못된 요청 오류") //메시지 직접 입력
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad") //메시지 코드화
public class BadRequestException extends RuntimeException {
}
