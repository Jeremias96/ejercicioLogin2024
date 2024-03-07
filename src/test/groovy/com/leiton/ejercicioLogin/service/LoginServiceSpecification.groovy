import spock.lang.Specification

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

import com.leiton.ejercicioLogin.EjercicioLoginApplication
import com.leiton.ejercicioLogin.controller.LoginController
import com.leiton.ejercicioLogin.service.LoginService
import com.leiton.ejercicioLogin.dto.SignUpRequest
import com.leiton.ejercicioLogin.dto.SignUpResponse
import com.leiton.ejercicioLogin.dto.PhoneDTO
import com.leiton.ejercicioLogin.dto.LoginRequest
import com.leiton.ejercicioLogin.exception.EmailValidationException
import com.leiton.ejercicioLogin.exception.PasswordValidationException
import com.leiton.ejercicioLogin.exception.UserAlreadyExistsException
import com.leiton.ejercicioLogin.exception.UserNotFoundException
import com.leiton.ejercicioLogin.utils.JwtUtils

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = EjercicioLoginApplication)
class LoginServiceSpecification extends Specification {

    @Autowired
    private LoginService loginService

    def "sign-up should validate correct request"(){
        when:
            loginService.signUp(new SignUpRequest("name", "test1@mail.com", "a2asfGfdfdf4", [new PhoneDTO(123L, 456, "AR")]))

        then:
            noExceptionThrown()
    }

    def "sign-up should throw exception on incorrect email"(){
        when:
            loginService.signUp(new SignUpRequest("name", "test2@mail", "a2asfGfdfdf4", [new PhoneDTO(123L, 456, "AR")]))

        then:
            thrown(EmailValidationException)
    }

    def "sign-up should throw exception on incorrect password"(){
        when:
            loginService.signUp(new SignUpRequest("name", "test3@mail.com", password, [new PhoneDTO(123L, 456, "AR")]))

        then:
            thrown(PasswordValidationException)

        where:
            password        | _
            "password"      | _
            "a22sfGfdfdf4"  | _
            "a2asfgfdfdf4"  | _
            "a2asfgFDFdf4"  | _
    }

    def "sign-up should let name and phone to be optional"(){
        when:
            loginService.signUp(SignUpRequest.builder().email("test4@mail.com").password("a2asfGfdfdf4").build())

        then:
            noExceptionThrown()
    }

    def "sign-up shouldn't let register an already registered user"(){
        when:
            loginService.signUp(new SignUpRequest("name", "test6@mail.com", "a2asfGfdfdf4", [new PhoneDTO(123L, 456, "AR")]))
            loginService.signUp(new SignUpRequest("otherName", "test6@mail.com", "a2asfGfdfdf4", [new PhoneDTO(123L, 456, "AR")]))

        then:
            thrown(UserAlreadyExistsException)
    }

    def "login should retrieve correct user" (){
        when:
            def response = loginService.signUp(new SignUpRequest("name", "test7@mail.com", "a2asfGfdfdf4", [new PhoneDTO(123L, 456, "AR")]))
            loginService.login(new LoginRequest(response.token));
        
        then:
            noExceptionThrown()
    }

    def "login should throw exception on not found user" (){
        when:
            loginService.login(new LoginRequest("fakeToken"));

        then:
            thrown(UserNotFoundException)
    }

    def "login should change token when logged in" () {
        when:
            def signUpResponse = loginService.signUp(new SignUpRequest("name", "test8@mail.com", "a2asfGfdfdf4", [new PhoneDTO(123L, 456, "AR")]))
            def loginResponse = loginService.login(new LoginRequest(signUpResponse.token));
        
        then:
            signUpResponse.token != loginResponse.token
    }
}