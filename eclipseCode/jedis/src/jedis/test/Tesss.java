package jedis.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Tesss{
	
	private int count;
	public Tesss()
	{
		System.out.println("A Demo object has been created"+"====="+count);
	}
	protected void addOne()
	{
		count++;
	}

	
	public static void main(String[] args) {
		JedisPool js = new JedisPool("192.168.59.128",6379);
		Jedis jedis = js.getResource();

		jedis.set("age", "18");
		
		System.out.println(jedis.get("age"));
		
		js.close();
		jedis.close();
	
		 
		//new Tesss();
		
	}
}
