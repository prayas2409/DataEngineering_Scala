import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession}


class CreateDataframe{

  def fromList (list2: List[Any], sparkSession: SparkSession, listscm : StructType,count:Integer): Unit={
    val list1 = sparkSession.sparkContext.parallelize(list2)
    val rowRDD = list1.map(e => Row( for( a <- 0 until count) e(a)))
    val df = sparkSession.createDataFrame(rowRDD,listscm)
    println("Showing the dataframe with sent schema")
    df.show()
    df.printSchema()
    df.createTempView("Temporary_Table1")
    println("Table created succesfully")
    sparkSession.sql("select * from Temporary_Table1 where Age>30").show()
  }

  def fromList(list: List[Any],sparkSession: SparkSession,count:Integer,schema:StructType): Unit ={
    val list1 =  sparkSession.sparkContext.parallelize(list)
    val rowRDD = list1.map(e => Row( for( a <- 0 until count) e(a)))
    var df = sparkSession.createDataFrame(rowRDD,schema)
    println("Showing the dataframe without defined schema")
    df.show()
    df.printSchema()
    df.createTempView("Temporary_Table1")
    println("Table created succesfully")
    sparkSession.sql("select * from Temporary_Table1").show()
  }

  def fromFile(file:String,sparkSession: SparkSession,schema:StructType)={
    var df = sparkSession.read
      .option("inferSchema", "true")
      .option("header", "false")
      .schema(schema)
      .csv("src/test/scala/Week5/data/a.txt")
    println("Data")
    df.printSchema()
    df.show()
    df.createTempView("Temporary_Table1")
    println("Table created succesfully")
    sparkSession.sql("select * from Temporary_Table1").show()
  }
}
