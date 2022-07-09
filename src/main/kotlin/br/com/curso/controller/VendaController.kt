package br.com.curso.controller

import br.com.curso.application.usecase.realizarVenda.IRealizarVendaUseCase
import br.com.curso.controller.request.RealizarVendaRequest
import br.com.curso.controller.response.RealizarVendaResponse
import br.com.curso.extension.toCommand
import br.com.curso.extension.toRealizarVendaResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/vendas")
class VendaController (
    private val realizarVendaUseCase: IRealizarVendaUseCase)
{


    @Post
    fun cadastrarVeiculo(@Body cadastrarVeiculoRequest: RealizarVendaRequest) : HttpResponse<RealizarVendaResponse>
    {
        var response = realizarVendaUseCase.execute(cadastrarVeiculoRequest.toCommand())
        return HttpResponse.created(response.toRealizarVendaResponse())
    }
}

