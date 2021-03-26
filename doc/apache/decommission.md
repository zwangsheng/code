# spark.decommission.enable

## meaning

doc
> When decommission enabled, Spark will try its best to shut down the executor gracefully. Spark will try to migrate
> all the RDD blocks (controlled by spark.storage.decommission.rddBlocks.enabled)
> and shuffle blocks (controlled by spark.storage.decommission.shuffleBlocks.enabled) from the decommissioning executor
> to a remote executor when spark.storage.decommission.enabled is enabled. With decommission enabled,
> Spark will also decommission an executor instead of killing when spark.dynamicAllocation.enable enabled.

In my opinion, this will help spark on k8s to make better dynamicAllocation.

As it knew to us all, when enable dynamicAllocation, you need an external shuffle service. But spark on k8s does not have
it own external shuffle service. In community, we can see some issues to make independent external shuffle service to help.
And also community have [SPARK-27963 (core) Allow dynamic allocation without a shuffle service](https://github.com/apache/spark/pull/24817)
this PR suggest another way to help remove executor by not kill the executors which may be needed.By setting the conf of timeOut,
those need executors will be saved for a foreseeable period of time.

## TO BE CONTINUE