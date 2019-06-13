
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import junit.framework._


object DataframeTestCases extends TestCase{

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
    .appName("test cases").master("local").getOrCreate()

    var test = new CreateDataframe()
    var list = List(List("prayas",23,"ngp"), List("sam",32,"kamp"),List("nik",54,"jbl"))
    var schema = StructType(
      StructField("Name",StringType,true)::
        StructField("Age",IntegerType,true)::
        StructField("City",StringType,true)::Nil
    )

    test.fromList(list,spark,3,schema)
    var dfwithoutheader = spark.read
      .option("inferSchema", "true")
      .option("header", "false")
      .schema(schema)
      .csv("src/main/scala/data/a.txt")

    var dfwithheader = spark.read
      .option("inferSchema", "true")
      .option("header", "false")
      .schema(schema)
      .csv("src/main/scala/data/withheader.txt")
    Assert.assertEquals(test.fromFile("src/main/scala/data/a.txt",spark,schema),dfwithoutheader)
    Assert.assertEquals(test.fromFile("src/main/scala/data/withheader.txt",spark),dfwithheader)
  }

}
