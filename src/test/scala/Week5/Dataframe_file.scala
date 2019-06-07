package Week5

import org.apache.spark.sql.SparkSession

object Dataframe_file {

  def main(args: Array[String]): Unit = {

    var spark = SparkSession
      .builder()
      .appName("Dataframe_from_file")
      .master("local")
      .getOrCreate()

    // Defining the structure of the data frame

    //    var schema = StructType(
    //      Array(StructField("Name",StringType,false),
    //      StructField("Age",IntegerType,true),
    //        StructField("City",StringType,true)))


    //
    //    var df = spark.read
    //  .option("inferSchema", "true")
    //  .option("header", "false")
    //  .schema(schema)
    //  .csv("src/test/scala/Week5/data/a.txt")
    //
    //    df.show()
    //    df.printSchema()

    //    var list = List(1,2,23,34,5)

    //    var schema = StructType(
    //     StructField("Number",IntegerType,false)::Nil)

    //    println("Printing file")

    /*
    var file = spark.sparkContext.textFile("src/test/scala/Week5/data/a.txt")
    file.foreach(println(_))

    var s = (file.map(List(_)))
    s.foreach(println(_))

    println("Printing rows")
    var rows = file.foreach(Row(_))
    rows.foreach(println(_))
    */

    //    var list = spark.sparkContext.parallelize(List(List("prayas",23,"ngp"), List("sam",32,"kamp"),List("nik",54,"jbl")))
    //    println("Printing the list"+list)
    //    list.foreach(println(_))
    //
    //    var r = list.map(Row(_))
    //    println("printing"+r)
    //
    //    println("vals in r")
    //    r.foreach(println(_))


    //    var df = spark.createDataFrame(r,schema)
    //    var x = s.foreach(_.split(" ")
    //    file.foreach(println(_))

    //    val df = spark.createDataFrame(List(List("prayas",23,"ngp"),List("sam",32,"kamp"),List("nik",54,"jbl")).map(x=> (x(0),x(1),x(2))))
    //    df.show()



    /*
      // Creation of sql table
      var s = spark.sparkContext.textFile("src/test/scala/Week5/data/a.txt",3)
      println("Total number of partiions",s.getNumPartitions)

      df.createTempView("Temporary_Table1")

      println("Table created succesfully")

      spark.sql("select * from Temporary_Table1 where number>2").show()
    */


  }

}
