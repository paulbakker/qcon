package webshop.stats;

import org.amdatu.scheduling.annotations.RepeatForever;
import org.amdatu.scheduling.annotations.RepeatInterval;
import org.apache.felix.dm.annotation.api.Component;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Component
@RepeatForever
@RepeatInterval(period=RepeatInterval.SECOND, value = 5) 
public class StatsTask implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Thanks everyone!");
	}

}
