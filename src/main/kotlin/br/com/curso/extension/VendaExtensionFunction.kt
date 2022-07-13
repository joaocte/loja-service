package br.com.curso.extension

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.controller.request.RealizarVendaRequest
import br.com.curso.controller.response.RealizarVendaResponse
import br.com.curso.domain.Parcela
import br.com.curso.domain.Veiculo
import br.com.curso.domain.Venda
import br.com.curso.infrastructure.model.ParcelaModel
import br.com.curso.infrastructure.model.VeiculoModel
import br.com.curso.infrastructure.model.VendaModel
import br.com.curso.service.model.VeiculoResponse

fun RealizarVendaRequest.toCommand() : RealizarVendaCommand {
    return RealizarVendaCommand(this.nomeCliente, this.idVeiculo, this.numeroParcelas)
}

fun RealizarVendaCommandResponse.toRealizarVendaResponse(): RealizarVendaResponse{
    return RealizarVendaResponse(this.id)
}

fun VeiculoResponse.toDomain() : Veiculo {
    return Veiculo(this.id, this.modelo, this.marca, this.anoFabricacao, this.anoModelo, this.placa, this.valor)
}

 fun Venda.toModel(): VendaModel {
    return VendaModel(this.id, this.nomeCliente, this.veiculo.toModel(), this.valor, this.parcelas.map { it.toModel() })
}

 fun Parcela.toModel()  : ParcelaModel {
    return ParcelaModel(this.numeroParcela, this.valorParcela, this.dataVencimento)
}

 fun Veiculo.toModel()  : VeiculoModel {
    return VeiculoModel(this.id, this.modelo, this.marca, this.anoFabricacao, this.anoModelo, this.placa, this.valor)
}

