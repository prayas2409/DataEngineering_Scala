//
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
//
//object DataframeTestCases {
//
//  def main(args: Array[String]): Unit = {
//    val spark = SparkSession.builder()
//    .appName("test cases").master("local").getOrCreate()
//
//    var test = new CreateDataframe()
//    var list = List(List("prayas",23,"ngp"), List("sam",32,"kamp"),List("nik",54,"jbl"))
//    var schema = StructType(
//      StructField("Name",StringType,true)::
//        StructField("Age",IntegerType,true)::
//        StructField("City",StringType,true)::Nil
//    )
//    test.fromList(list,spark,3,schema)
//    test.fromFile("src/main/scala/data/a.txt",spark,schema)
//
//  }
//
//}
