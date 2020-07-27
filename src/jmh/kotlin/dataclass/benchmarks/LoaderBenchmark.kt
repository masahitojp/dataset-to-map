package dataclass.benchmarks


import dataclass.Bar
import dataclass.Foo
import dataclass.utils.asMap
import dataclass.utils.serializeToMap
import dataclass.utils.serializeToMapWithJackson
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit


@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.All)
open class LoaderBenchmark {
    @Benchmark
    fun reflection(): Map<String, Any?> {
        val dataclass = Foo(1, Bar(1, 2))
        val gsonAsMap = dataclass.asMap()
        return gsonAsMap
    }

    @Benchmark
    fun gson(): Map<String, Any> {
        val dataclass = Foo(1, Bar(1, 2))
        val gsonAsMap = dataclass.serializeToMap()
        return gsonAsMap
    }

    @Benchmark
    fun jackson(): Map<String, Any> {
        val dataclass = Foo(1, Bar(1, 2))
        val dataclassAsMap = dataclass.serializeToMapWithJackson()
        return dataclassAsMap
    }
}