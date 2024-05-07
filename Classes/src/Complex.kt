import kotlin.math.abs

data class Complex(var numerator: Double, var denominator: Double) {
    init {
        if (numerator.toInt() >= Int.MAX_VALUE || denominator.toInt() >= Int.MAX_VALUE) {
            throw IllegalStateException("Значение превысило диапазон Int")}
        else if (numerator.toInt() <= Int.MIN_VALUE || denominator.toInt() <= Int.MIN_VALUE) {
            throw IllegalStateException("Значение превысило диапазон Int")}
    }

    operator fun plus(other: Complex): Complex {
        val newnumerator = this.numerator + other.numerator
        val denominator = this.denominator + other.denominator
        return Complex(newnumerator, denominator)
    }

    operator fun minus(other: Complex): Complex {
        val newnumerator = this.numerator - other.numerator
        val newdenominator = this.denominator - other.denominator
        return Complex(newnumerator, newdenominator)
    }

    operator fun times(other: Complex): Complex {
        val newnumerator = this.numerator * other.numerator - this.denominator * other.denominator
        val newdenominator = other.numerator * this.denominator + this.numerator * other.denominator
        return Complex(newnumerator, newdenominator)
    }

    operator fun div(other: Complex): Complex {
        val newnumerator = -((this.numerator*other.numerator + this.denominator*other.denominator)/
                (other.numerator * other.numerator + other.denominator * other.denominator))
        val newdenominator = ((other.numerator*this.denominator - this.numerator*other.denominator)/
                (other.numerator * other.numerator + other.denominator * other.denominator))
        if (newnumerator < 0 && newdenominator < 0) {
            return Complex(-newnumerator, -newdenominator)}
        else {
            return Complex(newnumerator, newdenominator)
        }
    }

    override fun toString(): String {     /*переопределяет строковое представление об объекте*/
        if (denominator >= 0) {
            return "${numerator.toInt()} + i${denominator.toInt()}"
        } else {
            return "${numerator.toInt()} - i${-denominator.toInt()}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Complex
        val epsilon = 0.00001

        if (abs(numerator - other.numerator) > epsilon) return false
        if (abs(denominator - other.denominator) > epsilon) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }


}

//fun main() {
//    println(Int.MAX_VALUE)
//    val first = Complex(5.0, 3.0)
//    val second = Complex(4.0, 5.0)
//    println("a = $first")
//    println("b = $second")
//    println("a + b = ${first + second}")
//    println("a - b = ${first - second}")
//    println("a * b = ${first * second}")
//    println("a / b = ${first / second}")
//    println(first)
//    println(second)
//}

