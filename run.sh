#
#
#start-dfs.sh
#start-yarn.sh
#hadoop fs -put ./L_AIRPORT_ID.csv
#hadoop fs -put ./664600583_T_ONTIME_sample.csv
mvn package
hadoop fs -rm -f -r output
export HADOOP_CLASSPATH=./target/hadoop-examples-1.0-SNAPSHOT.jar
hadoop App L_AIRPORT_ID.csv 664600583_T_ONTIME_sample.csv output
hadoop fs -copyToLocal output