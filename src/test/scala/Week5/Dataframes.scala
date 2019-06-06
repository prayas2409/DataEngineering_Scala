package Week5

import org.apache.spark.sql.SparkSession

object Dataframes {

  def main(args: Array[String]): Unit = {

    var spark_conf = SparkSession.builder().appName("Dataframe").master("local").getOrCreate()

    var arr = Array(1,2,3,4,5)
    var df_rdd = spark_conf.parallelize(arr,2)


  }

}
