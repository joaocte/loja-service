package br.com.curso.application.usecase.realizarVenda

import br.com.curso.application.`in`.RealizarVendaCommand
import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.domain.Parcela
import br.com.curso.domain.Venda
import br.com.curso.exception.custoException.NotFoundException
import br.com.curso.extension.toDomain
import br.com.curso.extension.toModel
import br.com.curso.infrastructure.IVendaRepository
import br.com.curso.producer.IVendaProducer
import br.com.curso.service.IVeiculoService
import br.com.curso.service.model.VeiculoResponse
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Singleton
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

@Singleton
class RealizarVeiculoUseCase(
    private val veiculoService: IVeiculoService,
    private val repository: IVendaRepository,
    private val objectMapper: ObjectMapper,
    private val producer: IVendaProducer,

    ) : IRealizarVendaUseCase {
    override fun execute(cadastrarVeiculoCommand: RealizarVendaCommand): RealizarVendaCommandResponse {

        var parcelas: List<Parcela> = ArrayList()

        val veiculo = veiculoService.obterVeiculoPorId(cadastrarVeiculoCommand.idVeiculo)
            ?: throw NotFoundException("Veiculo não encontrado com o ID ${cadastrarVeiculoCommand.idVeiculo}")


        val valorParcela =
            veiculo.valor.divide(cadastrarVeiculoCommand.numeroParcelas.toBigDecimal(), RoundingMode.HALF_UP)

        var data = LocalDate.now().plusMonths(1)

        for (i in 1..cadastrarVeiculoCommand.numeroParcelas) {

            var parcela = Parcela(i, valorParcela, data)
            parcelas = parcelas.plus(parcela)
            data = data.plusMonths(1)

        }
        var venda = Venda(id = null, cadastrarVeiculoCommand.nomeCliente, veiculo.toDomain(), veiculo.valor, parcelas)

        var vendaModel = venda.toModel()

        var vendaDatabase = repository.save(vendaModel)


        var event = objectMapper.writeValueAsString(vendaDatabase)

        producer.send(vendaDatabase.id.toString(), event)

        return RealizarVendaCommandResponse(
            vendaDatabase.id!!,
            cadastrarVeiculoCommand.nomeCliente,
            cadastrarVeiculoCommand.numeroParcelas,
            vendaDatabase.valor,
            parcelas
        )
    }
}
