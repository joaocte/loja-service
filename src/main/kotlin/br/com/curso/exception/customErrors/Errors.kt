package br.com.curso.exception.customErrors

enum class Errors(val code: String, val message: String) {
    MSV1000("MSV-1000", "Registro não encontrado"),
    MSV1001("MSV-1001", "Veiculo Já Cadastrado"),
}