package com.redis1;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Redis set��������
 *
 */
public class RedisHash {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		// �������
		System.out.println(jedis.flushDB());
		String key = "myhash";
		Map hash = new HashMap();
		hash.put("aaa", "11");
		hash.put("bbb", "22");
		hash.put("ccc", "33");
		// �������
		jedis.hmset(key, hash);
		jedis.hset(key, "ddd", "44");
		// ��ȡhash������Ԫ��(keyֵ)
		System.out.println(jedis.hkeys(key));
		// ��ȡhash�����е�key��Ӧ��valueֵ
		System.out.println(jedis.hvals(key));
		// ��ȡhash������Ԫ�ص�����
		System.out.println(jedis.hlen(key));
		// ��ȡhash��ȫ�������ֵ,��Map<string, string=""> ����ʽ����
		Map elements = jedis.hgetAll(key);
		System.out.println(elements);
		// �жϸ���keyֵ�Ƿ�����ڹ�ϣ����
		System.out.println(jedis.hexists(key, "bbb"));
		// ��ȡhash����ָ���ֶζ�Ӧ��ֵ
		System.out.println(jedis.hmget(key, "aaa", "bbb"));
		// ��ȡָ����ֵ
		System.out.println(jedis.hget(key, "aaa"));
		// ɾ��ָ����ֵ
		System.out.println(jedis.hdel(key, "aaa"));
		System.out.println(jedis.hgetAll(key));
		// Ϊkey�е��� field ��ֵ�������� increment
		System.out.println(jedis.hincrBy(key, "bbb", 100));
		System.out.println(jedis.hgetAll(key));
	}




}
