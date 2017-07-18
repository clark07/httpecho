package com.cs.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by chensheng350 on 2017/7/13.
 */
public class EventBusConsumer {

	@Subscribe
	public void eventLisener(Object event){
		System.out.println(event);
	}

}

