package com.redis1;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Redis set��������
 *
 */
public class RedisZset {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println(jedis.flushDB());
		String key = "mysortset";
		Map scoreMembers = new HashMap();
		scoreMembers.put("aaa", 1001.0);
		scoreMembers.put("bbb", 1002.0);
		scoreMembers.put("ccc", 1003.0);
		// �������
		jedis.zadd(key, 1004.0, "ddd");
		jedis.zadd(key, scoreMembers);
		// ��ȡһ������ļ����еĳ�Ա����
		System.out.println(jedis.zcard(key));
		// ���صĳ�Ա��ָ����Χ�ڵ����򼯺ϣ���0��ʾ���򼯵�һ����Ա����1��ʾ���򼯵ڶ�����Ա���Դ����ơ�
		// �����±꣬��-1��ʾ���һ����Ա��-2��ʾ�����ڶ�����Ա
		Set<String> coll = jedis.zrange(key, 0, -1);
		System.out.println(coll);
		// ���صĳ�Ա��ָ����Χ�ڵ����򼯺�
		coll = jedis.zrevrange(key, 0, -1);
		System.out.println(coll);
		// Ԫ���±�
		System.out.println(jedis.zscore(key, "bbb"));
		// ɾ��Ԫ��
		System.out.println(jedis.zrem(key, "aaa"));
		System.out.println(jedis.zrange(key, 0, -1));
		// ����ֵ��Χ�ڵĳ�Ա��
		System.out.println(jedis.zcount(key, 1002.0, 1003.0));
	}




}
