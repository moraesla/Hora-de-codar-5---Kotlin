fun main() {
    var saldo = 150.00
    val senhaCorreta = 3589
    var nome: String

    fun verSaldo(){
        println("Seu saldo atual é: R$ %.2f".format(saldo))
    }

    fun verExtrato(){
        println("Extrato da conta:")
        println("- Depósito: R$ 200,00")
        println("- Compra: Supermercado - R$ 50,00")
        println("- Compra: Restaurante - R$ 30,00")
        println("- Depósito: R$ 100,00")
    }

    fun fazerSaque(){
        print("Qual o valor para saque? ")
        val saque = readLine()?.toDoubleOrNull()

        if (saque == null || saque <= 0) {
            println("Por favor, informe um número válido.")
        } else if (saque > saldo) {
            println("Saldo insuficiente.")
        } else {
            saldo -= saque
            println("Saque de R$ %.2f realizado com sucesso.".format(saque))
        }
    }

    fun fazerDeposito(){
        print("Qual o valor para depósito? ")
        val deposito = readLine()?.toDoubleOrNull()

        if (deposito == null || deposito <= 0) {
            println("Por favor, informe um número válido.")
        } else {
            saldo += deposito
            println("Depósito de R$ %.2f realizado com sucesso.".format(deposito))
        }
    }

    fun fazerTransferencia(){
        print("Informe o número da conta para transferência: ")
        val conta = readLine()?.toIntOrNull()

        print("Informe o valor da transferência: ")
        val valorTransferencia = readLine()?.toDoubleOrNull()

        if (conta == null || valorTransferencia == null || valorTransferencia <= 0 || valorTransferencia > saldo) {
            println("Operação não autorizada.")
        } else {
            saldo -= valorTransferencia
            println("Transferência de R$ %.2f realizada para a conta %d com sucesso!".format(valorTransferencia, conta))
        }
    }

    fun erro(){
        println("Opção inválida. Escolha uma opção entre 1 e 6.")
    }

    fun sair(nome: String){
        println("$nome, foi um prazer ter você aqui!")
    }

    // Início de td
    print("Por favor, informe seu nome: ")
    nome = readLine().orEmpty()
    println("Olá, $nome! É um prazer ter você por aqui!")

    var opcao: Int

    do {
        println("\nEscolha uma opção:")
        println("1. Ver saldo")
        println("2. Ver extrato")
        println("3. Fazer saque")
        println("4. Fazer depósito")
        println("5. Fazer transferência")
        println("6. Sair")

        print("Digite a opção desejada: ")
        opcao = readLine()?.toIntOrNull() ?: -1

        println("A opção selecionada foi: $opcao")

        when (opcao){
            1 -> verSaldo()
            2 -> verExtrato()
            3 -> fazerSaque()
            4 -> fazerDeposito()
            5 -> fazerTransferencia()
            6 -> sair(nome)
            else -> erro()
        }
    } while (opcao != 6)
}