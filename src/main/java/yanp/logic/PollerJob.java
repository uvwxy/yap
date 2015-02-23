package yanp.logic;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class PollerJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobKey key = context.getJobDetail().getKey();
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		String ip = dataMap.getString("ip");
		String ooid = dataMap.getString("ooid");

		System.out.println("Instance " + key + " of PollerJob says: " + ip
				+ " should be polled about " + ooid);
	}

}
