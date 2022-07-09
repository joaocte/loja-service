package br.com.curso.application.usecase.realizarVenda

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.service.IVeiculoService
import br.com.curso.service.model.VeiculoResponse
import jakarta.inject.Singleton
import java.util.*

@Singleton
class RealizarVeiculoUseCase (private val veiculoService: IVeiculoService) : IRealizarVendaUseCase {
   override fun execute(cadastrarVeiculoCommand: RealizarVendaCommand) : RealizarVendaCommandResponse{

       val veiculos: MutableList<VeiculoResponse> = mutableListOf()


       cadastrarVeiculoCommand.idVeiculos.forEach{
           val veiculo = veiculoService.obterVeiculoPorId(it)
            if(veiculo != null)
            {
                veiculos.add(veiculo)
            }
       }

       println(veiculos)

       return RealizarVendaCommandResponse(1)
    }
}