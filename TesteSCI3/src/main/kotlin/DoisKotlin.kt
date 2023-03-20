import java.lang.NumberFormatException

fun main(args: Array<String>) {

   val listNum = mutableListOf<Double>()

    println("Questão nº 2.\n");
    println("A seguir insira 5 números.\n");
    var i = 1;

    do {
        println("Insira o $i"+"º número");
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

    println("O maior número digitado valor é: " + listNum.max());
    println("O menor número digitado valor é: " +listNum.min());
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