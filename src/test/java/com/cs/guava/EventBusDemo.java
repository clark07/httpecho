package com.cs.guava;

import com.google.common.eventbus.EventBus;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by chensheng350 on 2017/7/13.
 */
public class EventBusDemo {



	    public static void main(String[] args){

			EventBus eventBus = new EventBus();
			eventBus.register(new EventBusConsumer());

			eventBus.post(new CsEvent("name"));

	    }


	    @Data
		@AllArgsConstructor
	    public static class CsEvent{
	    	private String eventName;
		}
}
