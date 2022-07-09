package br.com.curso.application.usecase.realizarVenda

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse

interface IRealizarVendaUseCase {
    fun execute(cadastrarVeiculoCommand: RealizarVendaCommand) : RealizarVendaCommandResponse
}