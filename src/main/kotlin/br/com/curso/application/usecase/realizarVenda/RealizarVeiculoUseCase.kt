package br.com.curso.application.usecase.realizarVenda

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.domain.Parcela
import br.com.curso.domain.Venda
import br.com.curso.extension.toDomain
import br.com.curso.service.IVeiculoService
import br.com.curso.service.model.VeiculoResponse
import jakarta.inject.Singleton
import java.math.BigDecimal
import java.time.LocalDate

@Singleton
class RealizarVeiculoUseCase (private val veiculoService: IVeiculoService) : IRealizarVendaUseCase {
   override fun execute(cadastrarVeiculoCommand: RealizarVendaCommand) : RealizarVendaCommandResponse{

       val veiculos: MutableList<VeiculoResponse> = mutableListOf()
       var parcelas : List<Parcela> = ArrayList()

       cadastrarVeiculoCommand.idVeiculos.forEach{
           val veiculo = veiculoService.obterVeiculoPorId(it)
            if(veiculo != null)
            {
                veiculos.add(veiculo)
            }
       }

       val valorParcela = veiculos.sumOf { it.valor }.divide(cadastrarVeiculoCommand.numeroParcelas.toBigDecimal())

       val data = LocalDate.now()

       for (i in 1.. cadastrarVeiculoCommand.numeroParcelas)
       {
           var parcela = Parcela(i,valorParcela, data)
          parcelas =  parcelas.plus(parcela)
           data.plusMonths(1)
       }
       var venda = Venda(1,cadastrarVeiculoCommand.nomeCliente, veiculos.map { it.toDomain() }.toList(), valorParcela, parcelas)


       println(venda)

       return RealizarVendaCommandResponse(1, cadastrarVeiculoCommand.nomeCliente, cadastrarVeiculoCommand.numeroParcelas, BigDecimal(10), parcelas)
    }
}

