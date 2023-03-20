import java.lang.NumberFormatException

fun main(args: Array<String>) {

    val listNum = mutableListOf<Double>()

    println("Questão nº 1.\n");
    println("A seguir insira 5 números.\n");
    var i = 1;

    do {
        println("Insira o $i" + "º número");
        var num = readln();

        var verify = verifyNum(num);

        if (verify) {
            listNum.add(num.toDouble());
            i++;
        } else {
            println("O caracter inserido não é um número válido");
            if (i != 1) i--;
        }

    } while (i <= 5)

    var par = "Os números paraes são: ";
    var impar = "Os números impares são: ";
    var soma = 0.0;

    listNum.forEach {
        soma += it;

        if ((it % 2).toInt() == 0) {
            par += it.toString() + ", ";
        } else impar += it.toString() + ", ";
    }
    var average  = soma / listNum.size

    println(par + "\n" + impar);
    println("A média dos números é $average.");
}

private fun verifyNum(s: String): Boolean {
    //Função para verificar se o carcter digitado é número.

    return try {
        s.toDouble();
        true;
    } catch (e: NumberFormatException) {
        false;
    }
}
