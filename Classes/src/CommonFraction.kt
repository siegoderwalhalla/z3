import kotlin.math.abs        /*модуль*/

data class CommonFraction(private var numerator: Int, private var denominator: Int = 1) {
    init {
        try {                                           /*Проверка деления на 0*/
            numerator / denominator
        }
        catch (e:Exception) {                                  /*Обработка исключения*/
            println("Denominator can't be 0")
        }
        privateNodFinder()
    }

    private fun euclideanGCD(a: Int, b: Int): Int {         /* находим НОД числителя и знаментеля */
        var x = abs(a)
        var y = abs(b)
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    private fun privateNodFinder() {
        val nod = euclideanGCD(numerator, denominator)
        val isNeg = numerator * denominator < 0             /* проверка, является ли дробь отрицательной */
        numerator /= nod
        denominator /= nod
        numerator = abs(numerator)
        denominator = abs(denominator)
        if (isNeg) {            /* если дробь отрицательная, то переносим знак минус в числитель */
            numerator *= -1
        }
    }

    fun plus(other: CommonFraction): CommonFraction {     /*сложение чисел если второе экземпляр является объектом класса Дробь*/
        val a = numerator
        val b = denominator
        val c = other.numerator
        val d = other.denominator
        return CommonFraction(a * d + b * c, b * d)
    }

    fun plus(other: Int): CommonFraction {       /*если второй экземпляр - это число*/
        return this.plus(CommonFraction(other))
    }

    fun minus(other: CommonFraction): CommonFraction {   /*метод вычитания*/
        val a = numerator
        val b = denominator
        val c = other.numerator
        val d = other.denominator
        return CommonFraction(a * d - b * c, b * d)
    }

    fun multiply(other: CommonFraction): CommonFraction {    /*метод умножения*/
        val a = numerator
        val b = denominator
        val c = other.numerator
        val d = other.denominator
        return CommonFraction(a * c, b * d)
    }

    fun divide(other: CommonFraction): CommonFraction {    /*метод деления*/
        val a = numerator
        val b = denominator
        val c = other.numerator
        val d = other.denominator
        return CommonFraction(a * d, b * c)
    }

    override fun toString(): String {     /*переопределяет строковое представление об объекте*/
        return "$numerator / $denominator"
    }
}

/*
fun main() {
    val a = Fraction(2, 0)
    val b = Fraction(4, 5)
    println("a = $a")
    println("b = $b")
    println()
    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println()
    println("a // b = ${a / b}")
}

 */