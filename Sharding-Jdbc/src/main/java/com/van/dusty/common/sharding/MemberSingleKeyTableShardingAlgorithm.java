package com.van.dusty.common.sharding;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;


/**
 * 分表逻辑
 * @author van
 *
 */
public class MemberSingleKeyTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
	@Override
	public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
		preciseShardingValue.getColumnName();
		preciseShardingValue.getLogicTableName();
		Long value=Long.parseLong(preciseShardingValue.getValue().toString());
		long suffixLong = value % 10;
		for (String tableName : collection) {
			if(tableName.endsWith(String.valueOf(suffixLong))){
				return tableName;
			}
		}
		return null;
	}

	/**
	 * sql between 规则
	 *//*
	public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
		Collection<String> result = new LinkedHashSet<String>(tableNames.size());
		Range<Long> range = (Range<Long>) shardingValue.getValueRange();
		for (long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
			Long modValue = i % 100;
			String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
			for (String each : tableNames) {
				if (each.endsWith(modStr)) {
					result.add(each);
				}
			}
		}
		return result;
	}

	*//**
	 * sql == 规则
	 *//*
	public String doEqualSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
		Long modValue = shardingValue.getValue() % 100;
		String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
		for (String each : tableNames) {
			if (each.endsWith(modStr)) {
				return each;
			}
		}
		throw new IllegalArgumentException();
	}

	*//**
	 * sql in 规则
	 *//*
	public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {

		Collection<String> result = new LinkedHashSet<String>(tableNames.size());
		Collection<Long> values = shardingValue.getValues();
		Iterator iter = values.iterator();
		while(iter.hasNext()){
			Long data=Long.parseLong(String.valueOf(iter.next()));
			Long modValue = data % 100;
			String modStr = modValue < 10 ? "0" + modValue : modValue.toString();
			for (String tableName : tableNames) {
				if (tableName.endsWith(modStr)) {
					result.add(tableName);
				}
			}
		}
		return result;
	}*/

}
