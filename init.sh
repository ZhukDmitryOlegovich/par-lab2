stop-dfs.sh
stop-yarn.sh
sudo /etc/init.d/ssh restart
ssh-add
rm -rf ~/hdata/namenode ~/hdata/datanode
hdfs namenode -format
start-dfs.sh
start-yarn.sh
hadoop fs -put ./L_AIRPORT_ID.csv
hadoop fs -put ./664600583_T_ONTIME_sample.csv