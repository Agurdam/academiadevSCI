import java.lang.NumberFormatException
import java.util.*

private lateinit var name: String;

private var vectorStudent = Vector<Student>(3);

data class Student(val nameS: String, val note: Vector<Double>)

fun main(args: Array<String>) {
    println("Questão nº 5.\n")
    for (i in 0..2) {
        fName(i+1);
        fNotes(name)
    }
    average();
    bestAverage();
    worseAverage();
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

private fun fName(n: Int) {
    do {
        println("Insira o nome do $n" + "º aluno.\n")

        var name2 = readln();

        if (!verifyNum(name2)) {
            name = name2;
        } else println("Você digitou um número como nome do seu aluno")

    } while (verifyNum(name2))

}

private fun fNotes(name: String) {
    var i = 1;
    var note = Vector<Double>();
    do {
        println("Insira a $i" + "ª nota")
        var num = readln();
        var verify = verifyNum(num);
        if (verify) {
            note.add(num.toDouble())
            i++;
        } else {
            println("O caracter inserido não é um número válido")          
        }
    } while (i <= 4)

    addVector(name, note)
}

private fun addVector(name: String, note: Vector<Double>) {
    var student = Student(name, note)
    vectorStudent.add(student)
}

private fun average(v: Vector<Double>) {
    v.sum() / v.size
}

private fun average() {
    var v = vectorStudent;
    for (i in 0..v.size - 1) {
        println("A média do aluno ${v.get(i).nameS} é ${v.get(i).note.average()}")
    }
}

private fun bestAverage() {

    var v = vectorStudent;

    if ((v.get(0).note.average() > v.get(1).note.average()) &&
        (v.get(0).note.average() > v.get(2).note.average())
    ) {
        //Aluno na posição 0
        println("A média do aluno ${v.get(0).nameS} é a mais alta, ${v.get(0).note.average()}")

    } else if ((v.get(1).note.average() > v.get(0).note.average()) &&
        (v.get(1).note.average() > v.get(2).note.average())
    ) {
        //Aluno na posição 1
        println("A média do aluno ${v.get(1).nameS} é a mais alta, ${v.get(1).note.average()}")

    } else if ((v.get(2).note.average() > v.get(0).note.average()) &&
        (v.get(2).note.average() > v.get(1).note.average())
    ) {
        //Aluno na posição 2
        println("A média do aluno ${v.get(2).nameS} é a mais alta, ${v.get(2).note.average()}")

    }
}

private fun worseAverage() {
    
    var v = vectorStudent;
    
    if ((v.get(0).note.average() < v.get(1).note.average()) &&
        (v.get(0).note.average() < v.get(2).note.average())
    ) {
        //Aluno na posição 0
        println("A média do aluno ${v.get(0).nameS} é a mais baixa, ${v.get(0).note.average()}")

    } else if ((v.get(1).note.average() < v.get(0).note.average()) &&
        (v.get(1).note.average() < v.get(2).note.average())
    ) {
        //Aluno na posição 1
        println("A média do aluno ${v.get(1).nameS} é a mais baixa, ${v.get(1).note.average()}")

    } else if ((v.get(2).note.average() < v.get(0).note.average()) &&
        (v.get(2).note.average() < v.get(1).note.average())
    ) {
        //Aluno na posição 2
        println("A média do aluno ${v.get(2).nameS} é a mais baixa, ${v.get(2).note.average()}")

    }
}
