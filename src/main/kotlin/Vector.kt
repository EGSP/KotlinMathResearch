import kotlin.math.abs
import kotlin.math.sign

class Vector(val value:Float) {
    fun magnitude(): Float {
        return abs(value)
    }

    fun normalize(): Vector {
        return when (value) {
            0f -> Vector(0f)
            else -> Vector(sign(value))
        }
    }

    operator fun unaryMinus() = Vector(-value)
    operator fun unaryPlus() = Vector(abs(value))

    operator fun plus(vector: Vector) = Vector(value + vector.value)
    operator fun minus(vector: Vector) = Vector(value - vector.value)
    operator fun times(scalar: Float) = Vector(value * scalar)
}