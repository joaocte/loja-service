package br.com.curso.exception.handlers

import br.com.curso.exception.custoException.AlreadyRegisteredException
import br.com.curso.exception.customErrors.Errors
import br.com.curso.exception.response.ExceptionResponse
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Singleton
@Requires(classes = [AlreadyRegisteredException::class])
class AlreadyRegisteredExceptionHandler: ExceptionHandler<AlreadyRegisteredException, HttpResponse<*>>
{
    override fun handle(request: HttpRequest<*>?, exception: AlreadyRegisteredException): HttpResponse<*> {
        var erroResponse = ExceptionResponse(
            HttpStatus.CONFLICT,
            Errors.MSV1001.message,
            Errors.MSV1001.code
        )
        return HttpResponse
            .status<ExceptionResponse>(erroResponse.status)
            .body(erroResponse)

    }
}