package Week5

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{DataType, IntegerType, StringType, StructField, StructType}

object Dataframes {

  def main(args: Array[String]): Unit = {

    var spark = SparkSession
      .builder()
      .appName("Dataframe")
      .master("local")
      .getOrCreate()

    // dataframe from array
    var arr = spark.sparkContext.parallelize(List(1,2,3,4,5))
    val rowrdd = arr.map(Row(_))

    var schema = StructType(
    Array(StructField("Number",IntegerType,false)))

    var df = spark.createDataFrame(rowrdd,schema)
    df.show()

    println("Ended")
  }
}
