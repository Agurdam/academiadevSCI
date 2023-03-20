import java.lang.NumberFormatException
import java.util.Vector

var vectorNum = Vector<Double>(4);

fun main(args: Array<String>) {
println("Questão nº 4.\n")
    addNumber();
    printNumber();
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

private fun addNumber(){
    println("A seguir infrome 5 números");
    var i =1;

    do {
        println("Insira o $i"+"º número");
        var num = readln();

        var verify = verifyNum(num);

        if (verify) {
            vectorNum.add(num.toDouble());
            i++;
        } else {
            println("O caracter inserido não é um número válido");
            if (i != 1) i--;
        }
    } while (i <= 5)

}

private fun printNumber(){
    val print = "O número gravado na posição três é: ${vectorNum.get(3)}."
    println(print)
}
