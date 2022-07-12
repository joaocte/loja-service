package br.com.curso.extension

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.controller.request.RealizarVendaRequest
import br.com.curso.controller.response.RealizarVendaResponse
import br.com.curso.domain.Veiculo
import br.com.curso.service.model.VeiculoResponse

fun RealizarVendaRequest.toCommand() : RealizarVendaCommand {
    return RealizarVendaCommand(this.nomeCliente, this.idVeiculos, this.numeroParcelas)
}

fun RealizarVendaCommandResponse.toRealizarVendaResponse(): RealizarVendaResponse{
    return RealizarVendaResponse(this.id)
}

fun VeiculoResponse.toDomain() : Veiculo {
    return Veiculo(this.id, this.modelo, this.marca, this.anoFabricacao, this.anoModelo, this.placa, this.valor)
}