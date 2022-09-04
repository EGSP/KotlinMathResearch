import kotlin.math.pow
import kotlin.math.sqrt

class Vector2(val x:Float, val y:Float) {
    companion object Vector2Functions{
        val unit = Vector2(1f,1f)

        fun dot(a:Vector2, b:Vector2):Float = a.x * b.x + a.y*b.y
        fun project(base: Vector2, projecting: Vector2): Vector2 = unit * dot(base,projecting)

        fun dotNormalized(a:Vector2, b:Vector2):Float {
            // Если они будут не нормализованными, то наложение будет искажено.
            val an = a.normalized
            val bn = b.normalized
            return dot(an,bn)
        }
    }

    val magnitude get() = sqrt(x.pow(2)+y.pow(2))
    val magnitudeSqr get() = x.pow(2)+y.pow(2)

    val normalized get():Vector2 {
        val m = magnitude
        return when(m){
            0f -> Vector2(0f,0f)
            else -> this/m
        }
    }

    operator fun plus(vector: Vector2) = Vector2(x+vector.x,y+vector.y)
    operator fun minus(vector: Vector2) = Vector2(x-vector.x, y-vector.y)
    operator fun times(scalar: Float) = Vector2(x*scalar, y*scalar)
    operator fun times(vector: Vector2) = Vector2(x*vector.x, y*vector.y)
    operator fun div(scalar: Float) = Vector2(x/scalar,y/scalar)
}