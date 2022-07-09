package br.com.curso.extension

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.controller.request.RealizarVendaRequest
import br.com.curso.controller.response.RealizarVendaResponse

fun RealizarVendaRequest.toCommand() : RealizarVendaCommand {
    return RealizarVendaCommand(this.nomeCliente, this.idVeiculos, this.valorCompra, this.numeroParcelas)
}

fun RealizarVendaCommandResponse.toRealizarVendaResponse(): RealizarVendaResponse{
    return RealizarVendaResponse(this.id   )
}