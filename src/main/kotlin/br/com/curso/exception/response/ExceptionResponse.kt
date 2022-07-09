package br.com.curso.exception.response

import io.micronaut.http.HttpStatus

data class ExceptionResponse (
    var status : HttpStatus,
    var message : String,
    var internalCode : String,
)