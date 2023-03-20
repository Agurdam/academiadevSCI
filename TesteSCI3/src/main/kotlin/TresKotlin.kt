import java.lang.NumberFormatException

private val listNum = mutableListOf<Double>()
private lateinit var name: String;
fun main(args: Array<String>) {

    println("Questão nº 3.\n");

    do {
        fName();
        fNotes();
    } while (!stopApp())

    println("Aluno: $name.");
    isApproved(average())
}

private fun verifyNum(s: String): Boolean {
    //Função para verificar se o carcter digitado é número.

    return try {
        s.toDouble();
        true
    } catch (e: NumberFormatException) {
        false
    }

}

private fun fName() {
    do {
        println("Insira o nome do aluno.\n")

        var name2 = readln();
        if (!verifyNum(name2)) {
            name = name2;
        } else println("Você digitou um número como nome do seu aluno")

    } while (verifyNum(name2))

}

private fun fNotes() {
    var i = 1;
    do {
        println("Insira a $i" + "ª nota")
        var num = readln();
        var verify = verifyNum(num);
        if (verify) {
            listNum.add(num.toDouble());
            i++;
        } else {
            println("O caracter inserido não é um número válido")            
        }
    } while (i <= 4)
}

private fun stopApp(): Boolean {
    println("Digite 'sair' para parar a execução")
    var awser = readln();
    return awser.equals("sair", true)

}

private fun average(): Double {
    var average = listNum.sum() / listNum.size;
    println("Média: " + average)
    return average
}

private fun isApproved(d: Double) {
    if (d >= 6) {
        println("Aprovado.")
    } else println("Reprovado.")
}
