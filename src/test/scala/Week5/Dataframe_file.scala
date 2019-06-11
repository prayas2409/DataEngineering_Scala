package Week5

import org.apache.spark.sql.{Row, SparkSession, types}
import org.apache.spark.sql.types.{DataType, IntegerType, StringType, StructField, StructType}

object Dataframe_file {

  def main(args: Array[String]): Unit = {

    var spark = SparkSession
      .builder()
      .appName("Dataframe_from_file")
      .master("local")
      .getOrCreate()

    val someData = Seq(
      Row(24, "Prayas","Nagpur"),
      Row(23, "Saurabh","Mumbai"),
      Row(25, "Deepak","Jaipur")
    )
    val someSchema = List(
      StructField("Age", IntegerType, true),
      StructField("Name", StringType, true),
      StructField("City",StringType)
    )
    val someDF = spark.createDataFrame(
      spark.sparkContext.parallelize(someData),
      StructType(someSchema)
    )
    someDF.show()

    // Second df
    val schema = StructType(
      Array(StructField("Age",IntegerType,true)
      ,StructField("Name",StringType,true),
      StructField("City",StringType,true)))
    println("Data frame 2")
    val list = List((23,"Prayas","ngp"), (24,"saurabh","jaipur"))
    val scm = List(("Agea",IntegerType,true),("namea",StringType,false),("Citya",StringType,true))
    var d = spark.sparkContext.parallelize(list)

    // df 3
    // Importing the spark toDF
    val sc = spark.sparkContext
    val sqlContext= new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._
    var df = d.toDF("Age","UserName","City")
    df.show()
    df.printSchema()

    // df3
    println("Fourth dataframe contents same as rd")
    var dfnew = spark.createDataFrame(list)
    dfnew.show()
    dfnew.printSchema()

     // df4
    println("Fifth DF")
    val values = spark.sparkContext.parallelize(List(List("1", 1) ,List("2", 2) ,List("3", 3),List("4",4)))
    val rowRDD = values.map(e => Row(e(0), e(1)))
    val schem = StructType(
      Array(StructField("Name",StringType,true),
        StructField("Age",IntegerType,true)))

    val df2 = spark.createDataFrame(rowRDD,schem)
    df2.show()
    println(df2.printSchema())

    // df from file
        var df3 = spark.read
      .option("inferSchema", "true")
      .option("header", "false")
      .schema(schema)
      .csv("src/test/scala/Week5/data/a.txt")

        df3.show()
        df3.printSchema()

//
//    var file = spark.sparkContext.textFile("src/test/scala/Week5/data/a.txt")
//    file.foreach(getLines(_))

    var file = spark.sparkContext.textFile("src/test/scala/Week5/data/a.txt")
    println("Printing rows")
    var rows = Seq(file.map(Row(_)))
    println("Printing the seq rows")
    rows.foreach(println(_))
//    var df_file_sq = spark.createDataFrame(rows)

    println("Fifth Dataframe")
    var newlist = spark.sparkContext.parallelize(List(List("prayas",23,"ngp"), List("sam",32,"kamp"),List("nik",54,"jbl")))
    var rddlist = newlist.map(x => Row(x(0),x(1),x(2)))
    var schema4 = StructType(Array(
        StructField("Name",StringType,true),
        StructField("Age",IntegerType,false),
        StructField("City",StringType,true)
      ))
    var df4 = spark.createDataFrame(rddlist,schema4)
    df4.show()
    df4.printSchema()

//       Creation of sql table
      df4.createTempView("Temporary_Table1")

      println("Table created succesfully")
      spark.sql("select * from Temporary_Table1 where Age>30").show()

  }
}
