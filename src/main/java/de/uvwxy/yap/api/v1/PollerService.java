package de.uvwxy.yap.api.v1;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import de.uvwxy.yap.logic.PollerJob;

@Path("v1")
public class PollerService {

	@GET
	@Path("/startPoller")
	public String startPoller(@QueryParam(value = "ip") String ip,
			@QueryParam(value = "ooid") String ooid) throws SchedulerException {
		String ret = "Started for: " + ip;

		System.out.println(ret);
		JobDetail job = newJob(PollerJob.class).usingJobData("ip", ip)
				.usingJobData("ooid", ooid).build();

		Trigger trigger = newTrigger()
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(10)
								.repeatForever()).build();

		SchedulerFactory schedFact = new StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();

		sched.scheduleJob(job, trigger);
		sched.start();
		
		return ret;
	}
}
