package br.com.curso.exception.handlers

import br.com.curso.exception.custoException.NotFoundException
import br.com.curso.exception.customErrors.Errors
import br.com.curso.exception.response.ExceptionResponse
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Singleton
@Requires(classes = [NotFoundException::class])
class NotFoundExceptionHandler: ExceptionHandler<NotFoundException, HttpResponse<*>>
{
    override fun handle(request: HttpRequest<*>?, exception: NotFoundException): HttpResponse<*> {
        var erroResponse = ExceptionResponse(
            HttpStatus.NOT_FOUND,
            Errors.MSV1000.message,
            Errors.MSV1000.code
        )
        return HttpResponse.notFound(erroResponse)
    }
}